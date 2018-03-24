package uz.showme.simpledagger2.screen.detalis.heroes.list;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.subjects.PublishSubject;
import uz.showme.simpledagger2.R;
import uz.showme.simpledagger2.models.Hero;

/**
 * Created by root on 3/10/18.
 */

public class HeroViewHolder extends RecyclerView.ViewHolder {
    View view;

    @BindView(R.id.item_hero_image)
    ImageView imageHero;
    @BindView(R.id.item_hero_name)
    TextView nameHero;
    @BindView(R.id.item_hero_year)
    TextView dateReleaseHero;
    @BindView(R.id.item_hero_separator)
    View separatorHero;
    @BindView(R.id.item_hero_text)
    TextView descriptionHero;

    public HeroViewHolder(View itemView, PublishSubject<Integer> clickSubject) {
        super(itemView);
        this.view = itemView;
        ButterKnife.bind(this, view);
        view.setOnClickListener(v -> clickSubject.onNext(getAdapterPosition())
        );
    }
    void bind(Hero hero){
        Glide.with(view.getContext())
                .load(hero.getImage()).into(imageHero);

        nameHero.setText(TextUtils.isEmpty(hero.getTitle())? "missing titile" :hero.getTitle());
        dateReleaseHero.setText(TextUtils.isEmpty(hero.getYear())? "missing year" :hero.getYear());
        descriptionHero.setText(TextUtils.isEmpty(hero.getIntro())?"missing text": hero.getIntro());
        separatorHero.setBackgroundColor(Color.parseColor(hero.getColor()));

    }

}
