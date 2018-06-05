package net.luisjohnson.popularmovies.data;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import net.luisjohnson.popularmovies.R;

import java.net.URL;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder>{

    private Movie[] data;
    LayoutInflater inflater;


    public MovieAdapter(Context context, Movie[] movies) {
        inflater = LayoutInflater.from(context);
        data = movies;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //Context context = parent.getContext();
        int layoutIdForCellItem = R.layout.movie_item_cell;
        //inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForCellItem, parent,shouldAttachToParentImmediately);
        ViewHolder viewHolder =  new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Movie movie = data[position];

        URL url = movie.getPosterPath();

        Picasso.get()
                .load(url.toString())
                .into(holder.posterIv);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView posterIv;

        public ViewHolder(View itemView) {
            super(itemView);
            posterIv = (ImageView) itemView.findViewById(R.id.movie_poster);
        }
    }

}


