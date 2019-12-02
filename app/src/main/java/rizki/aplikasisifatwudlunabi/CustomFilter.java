package rizki.aplikasisifatwudlunabi;

import android.widget.Filter;

import java.util.ArrayList;

public class CustomFilter extends Filter {
    AdapterBerandaActivity adapter;
    ArrayList<SifatWudlu> filterList;

    public CustomFilter(ArrayList<SifatWudlu> filterList,AdapterBerandaActivity adapter)
    {
        this.adapter=adapter;
        this.filterList=filterList;

    }
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results=new FilterResults();
        //CHECK CONSTRAINT VALIDITY
        if(constraint != null && constraint.length() > 0)
        {
            //CHANGE TO UPPER
            constraint=constraint.toString().toUpperCase();
            //STORE OUR FILTERED PLAYERS
            ArrayList<SifatWudlu> filteredSifat=new ArrayList<>();

            for (int i=0;i<filterList.size();i++)
            {
                //CHECK
                if(filterList.get(i).getJudul().toUpperCase().contains(constraint))
                {
                    //ADD PLAYER TO FILTERED PLAYERS
                    filteredSifat.add(filterList.get(i));
                }
            }

            results.count=filteredSifat.size();
            results.values=filteredSifat;

        }else
        {
            results.count=filterList.size();
            results.values=filterList;
        }

        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {

    }
}
