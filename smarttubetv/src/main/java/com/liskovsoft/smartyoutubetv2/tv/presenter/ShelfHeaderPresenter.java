package com.liskovsoft.smartyoutubetv2.tv.presenter;

import android.graphics.Typeface;
import android.util.TypedValue;
import android.widget.TextView;

import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.RowHeaderPresenter;

import com.liskovsoft.smartyoutubetv2.tv.R;

/**
 * Shelf titles sit on the canvas in the YouTube TV language: white, medium weight,
 * never dimmed when focus is inside the row.
 */
public class ShelfHeaderPresenter extends RowHeaderPresenter {
    @Override
    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object item) {
        super.onBindViewHolder(viewHolder, item);

        TextView title = viewHolder.view.findViewById(R.id.row_header);
        if (title != null) {
            title.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));
            title.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                    viewHolder.view.getResources().getDimension(R.dimen.yttv_shelf_title_text_size));
            title.setTextColor(viewHolder.view.getResources().getColor(R.color.yttv_text_primary));
        }
    }

    @Override
    protected void onSelectLevelChanged(ViewHolder holder) {
        // Keep shelf titles at full strength whether or not the row holds focus.
        holder.view.setAlpha(1f);
    }
}
