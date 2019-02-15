package com.stickyrecycle;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.stickyrecycle.ItemFragment.OnListFragmentInteractionListener;
import com.stickyrecycle.dummy.DummyContent;
import com.stickyrecycle.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> implements StickyHeaderInterface {

    private final List<DummyItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyItemRecyclerViewAdapter(List<DummyItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public int getItemViewType(int position) {
        return mValues.get(position).itemType;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case DummyContent.ITEM_HEADER:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.fragment_header_item, parent, false);
                return new ViewHolder(view);
            case DummyContent.ITEM_HEADER_PENDING:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.fragment_header_pending_item, parent, false);
                return new ViewHolder(view);
            case DummyContent.ITEM_COLUMN:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.fragment_item, parent, false);
                return new ViewHolder(view);
            case DummyContent.ITEM_COLUMN_PENDING:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.fragment_dotted_item, parent, false);
                return new ViewHolder(view);
                default:
                    view = LayoutInflater.from(parent.getContext())
                            .inflate(R.layout.fragment_item, parent, false);
                    return new ViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
//        holder.mIdView.setText(mValues.get(position).id);
        holder.mContentView.setText(mValues.get(position).content);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
//        public final TextView mIdView;
        public final TextView mContentView;
        public DummyItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
//            mIdView = (TextView) view.findViewById(R.id.item_number);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }


    @Override
    public int getHeaderPositionForItem(int itemPosition) {
        int headerPosition = 0;
        do {
            if (this.isHeader(itemPosition)) {
                headerPosition = itemPosition;
                break;
            }
            itemPosition -= 1;
        } while (itemPosition >= 0);
        return headerPosition;
    }

    @Override
    public int getHeaderLayout(int headerPosition) {
        if (mValues.get(headerPosition).itemType == DummyContent.ITEM_HEADER)
            return R.layout.fragment_header_item;
        else {
            return R.layout.fragment_header_pending_item;
        }
    }

    @Override
    public void bindHeaderData(View header, int headerPosition) {
            // this method is called when your header move and you must not only bind header data in HeaderViewHolder
            //but also bind header data here.
            TextView tv = header.findViewById(R.id.content);
            tv.setText(mValues.get(headerPosition).content);
    }

    @Override
    public boolean isHeader(int itemPosition) {
        if (mValues.get(itemPosition).itemType == DummyContent.ITEM_HEADER || mValues.get(itemPosition).itemType == DummyContent.ITEM_HEADER_PENDING)
            return true;
        else
            return false;
    }

}
