package com.example.github1germogenov;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.github1germogenov.Contributor;
import com.squareup.picasso.Picasso;
import java.util.List;

public class ContributorAdapter extends RecyclerView.Adapter<ContributorAdapter.ContributorViewHolder> {

    private List<Contributor> mContributors;
    private Context mContext;

    public ContributorAdapter(Context context, List<Contributor> contributors) {
        this.mContext = context;
        this.mContributors = contributors;
    }

    @Override
    public ContributorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contributor, parent, false);
        return new ContributorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContributorViewHolder holder, int position) {
        Contributor contributor = mContributors.get(position);
        holder.bind(contributor);
    }

    @Override
    public int getItemCount() {
        return mContributors.size();
    }

    public class ContributorViewHolder extends RecyclerView.ViewHolder {
        ImageView contributorImg;
        TextView loginTextView;
        TextView contributionsTextView;

        public ContributorViewHolder(View itemView) {
            super(itemView);
            contributorImg = itemView.findViewById(R.id.imageView);
            loginTextView = itemView.findViewById(R.id.contributorLogin);
            contributionsTextView = itemView.findViewById(R.id.contributorNum);
        }

        public void bind(Contributor contributor) {
            Picasso.with(mContext).load(contributor.getPhoto()).into(contributorImg);
            loginTextView.setText(contributor.getLogin());
            contributionsTextView.setText(contributor.getContributions());
        }
    }
}