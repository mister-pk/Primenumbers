package com.software.primenumbers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class PrimeNumbersAdapter extends RecyclerView.Adapter<PrimeNumbersAdapter.PrimeViewHolder> {

    private LayoutInflater inflater;
    private PrimeNumbers primes;

    public PrimeNumbersAdapter(Context context,@NonNull PrimeNumbers primes) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.primes = primes;
    }
    @Override
    public PrimeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView item = (CardView) inflater.inflate(R.layout.prime_number_item, parent, false);
        return new PrimeViewHolder(item);
    }
    @Override
    public void onBindViewHolder(PrimeViewHolder holder, int position) {
        int i = getItem(position);
        holder.tvItemText.setText(String.valueOf(i));
    }

    @Override
    public int getItemCount() {
        return primes.size();
    }

    private int getItem(int position){
        if(position > primes.size() -20)
            primes.loadMore(new PrimeNumbers.OnLoadListener() {
                @Override
                public void onLoad(int position, int counter) {
                    notifyItemRangeInserted(position,counter);
                }
            });
        return primes.get(position);
    }

    static class PrimeViewHolder extends RecyclerView.ViewHolder {
        TextView tvItemText;

        PrimeViewHolder(View itemView) {
            super(itemView);
            tvItemText = (TextView) itemView.findViewById(R.id.tvItemText);

        }
    }
}
