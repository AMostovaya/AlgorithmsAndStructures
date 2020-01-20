import java.util.LinkedList;

public class Backpack {

    private LinkedList<Items> bestItems = new LinkedList<>();

    private double maxW;
    private double bestPrice;

    public Backpack(double _maxW)
    {
        maxW = _maxW;
    }

    // общий вес набора предметов
    private double CalcWeigth(LinkedList<Items> items)
    {
        double sumW = 0;

        for (Items i : items)
        {
            sumW += i.weight;
        }

        return sumW;
    }

    // общая стоимость набора предметов
    private double CalcPrice(LinkedList<Items> items)
    {
        double sumPrice = 0;

        for (Items i : items)
        {
            sumPrice += i.price;
        }

        return sumPrice;
    }

    // проверяем является ли данный набор лучшим решением задачи
    private void CheckSet(LinkedList<Items> items)
    {
        if (bestItems == null)
        {
            if (CalcWeigth(items) <= maxW)
            {
                bestItems = items;
                bestPrice = CalcPrice(items);
            }
        }
        else
        {
            if(CalcWeigth(items) <= maxW && CalcPrice(items) > bestPrice)
            {
                bestItems = items;
                bestPrice = CalcPrice(items);
            }
        }
    }

    // создание всех наборов перестановок значений
    public void MakeAllSets(LinkedList<Items> items)
    {
        if (items.size() > 0)
            CheckSet(items);

        for (int i = 0; i < items.size(); i++)
        {
            LinkedList<Items> newSet = new LinkedList<>(items);
            newSet.remove(i);
            MakeAllSets(newSet);
        }

    }

    // возвращает набор предметов
    public LinkedList<Items> GetBestSet()
    {
        return bestItems;
    }
}
