package uz.showme.simpledagger2.screen.detalis.heroes.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import rx.Observable;
import rx.subjects.PublishSubject;
import uz.showme.simpledagger2.R;
import uz.showme.simpledagger2.models.Hero;

/**
 * Created by root on 3/10/18.
 */

public class HeroesAdapter extends RecyclerView.Adapter<HeroViewHolder> {

    private final PublishSubject<Integer> itemClicks = PublishSubject.create();
    ArrayList<Hero> listHeroes = new ArrayList<>();

    public void  swapAdapter(ArrayList<Hero>heroes){
        this.listHeroes.clear();
        this.listHeroes.addAll(heroes);
        notifyDataSetChanged();
    }
    public Observable<Integer>observeClicks(){
        return itemClicks;
    }

    @Override
    public HeroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_hero,parent,false);
        return new HeroViewHolder(view,itemClicks);
    }

    @Override
    public void onBindViewHolder(HeroViewHolder holder, int position) {
        Hero hero =listHeroes.get(position);
        holder.bind(hero);

    }

    @Override
    public int getItemCount() {
        if (listHeroes !=null && listHeroes.size()>0){
            return listHeroes.size();
        }else {

            return 0;
        }
    }
}
