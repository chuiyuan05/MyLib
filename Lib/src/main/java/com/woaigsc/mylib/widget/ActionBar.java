package com.woaigsc.mylib.widget;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.woaigsc.mylib.R;

import java.util.LinkedList;


/**
 * Created by chuiyuan on 16-5-6.
 */
public class ActionBar extends RelativeLayout implements View.OnClickListener {
    private LayoutInflater mInflater;
    private RelativeLayout mBarView;
    private ImageView mLogoView;
    private View mBackIndicator;
    private TextView mTitleView;
    private LinearLayout mActionsView;
    private ImageButton mHomeButton;
    private RelativeLayout mHomeLayout;
    private ProgressBar mProgress;

    public ActionBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        mBarView = (RelativeLayout) mInflater.inflate(R.layout.actionbar, null);
        this.addView(mBarView);
        mLogoView = (ImageView) mBarView.findViewById(R.id.actionbar_home_logo);
        mHomeLayout = (RelativeLayout) mBarView.findViewById(R.id.actionbar_home_bg);
        mHomeButton = (ImageButton) mBarView.findViewById(R.id.actionbar_home_btn);
        mBackIndicator = mBarView.findViewById(R.id.actionbar_home_is_back);

        mTitleView = (TextView) mBarView.findViewById(R.id.actionbar_title);
        //Can add actions to it.
        mActionsView = (LinearLayout) mBarView.findViewById(R.id.actionbar_actions);

        mProgress = (ProgressBar) mBarView.findViewById(R.id.actionbar_progress);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ActionBar);
        CharSequence title = a.getString(R.styleable.ActionBar_title);
        if (title == null) {
            setTitle(title);
        }
        a.recycle();
    }

    @Override
    public void onClick(View v) {
        final Object tag = v.getTag();
        if (tag instanceof Action) {
            final Action action = (Action) tag;
            action.performAction(v);
        }
    }

    public void setHomeAction(Action action) {
        mHomeButton.setOnClickListener(this);
        mHomeButton.setTag(action);
        mHomeButton.setImageResource(action.getDrawable());
        mHomeLayout.setVisibility(View.VISIBLE);
    }

    public void clearHomeAction() {
        mHomeLayout.setVisibility(View.GONE);
    }

    /**
     * Shows the provided logo to the left in the actionbar.
     * This is meant to be used instead of the setHomeAction and
     * does not show a divider to the left of the provided logo.
     *
     * @param resId The drawable resource id.
     */
    public void setHomeLogo(int resId) {
        mLogoView.setImageResource(resId);
        mLogoView.setVisibility(View.VISIBLE);
        mHomeLayout.setVisibility(View.GONE);
    }

    /**
     * Emulating honeycomb
     *
     * @param show
     */
    public void setDisplayHomeAsUpEnabled(boolean show) {
        mBackIndicator.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    public void setTitle(CharSequence title) {
        mTitleView.setText(title);
    }

    /**
     * Add for setting font.
     * @return
     */
    public TextView getTitleView(){
        return mTitleView;
    }

    public void setTitle(int resid) {
        mTitleView.setText(resid);
    }

    public void setProgressBarVisibility(int visibility) {
        mProgress.setVisibility(visibility);
    }

    public int getProgressBarVisibility() {
        return mProgress.getVisibility();
    }

    public void setOnTitleClikListener(OnClickListener listener) {
        mTitleView.setOnClickListener(listener);
    }

    /**
     * Adds a list of {@link Action}s.
     *
     * @param actionList
     */
    public void addActions(ActionList actionList) {
        int actions = actionList.size();
        for (int i = 0; i < actions; i++) {
            addAction(actionList.get(i));
        }
    }

    /**
     * Adds a new {@link Action}
     *
     * @param action
     */
    public void addAction(Action action) {
        final int index = mActionsView.getChildCount();
        addAction(action, index);
    }

    /**
     * Adds a new {@link Action} at the specified index.
     *
     * @param action
     * @param index
     */
    public void addAction(Action action, int index) {
        mActionsView.addView(inflateAction(action), index);
    }

    /**
     * Removes all action views from this action bar.
     */
    public void removeAllActions() {
        mActionsView.removeAllViews();
    }

    /**
     * Remove an action from the action bar.
     *
     * @param index
     */
    public void removeActionAt(int index) {
        mActionsView.removeViewAt(index);
    }

    /**
     * Remove an action from the action bar.
     *
     * @param action
     */
    public void removeAction(Action action) {
        int childCount = mActionsView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = mActionsView.getChildAt(i);
            if (view != null) {
                final Object tag = view.getTag();
                if (tag instanceof Action && tag.equals(action)) {
                    mActionsView.removeView(view);
                }
            }
        }
    }

    /**
     * Returns the number of actions currently registered with the action bar.
     *
     * @return
     */
    public int getActionCount() {
        return mActionsView.getChildCount();
    }

    /**
     * Inflates a {@link View} with the given {@link Action}.
     *
     * @param action
     * @return
     */
    public View inflateAction(Action action) {
        View view = mInflater.inflate(R.layout.actionbar_item, mActionsView, false);

        ImageButton labelView =
                (ImageButton) view.findViewById(R.id.actionbar_item);
        labelView.setImageResource(action.getDrawable());

        view.setTag(action);
        view.setOnClickListener(this);
        return view;
    }

    /**
     * A {@link LinkedList} that holds a list of {@link Action}s.
     */
    public static class ActionList extends LinkedList<Action> {

    }

    /**
     * Define an action that could be performed, along with a
     * icon to show.
     */
    public interface Action {
        public int getDrawable();

        public void performAction(View view);
    }

    public static abstract class AbstractAction implements Action {
        final private int mDrawable;

        public AbstractAction(int mDrawable) {
            this.mDrawable = mDrawable;
        }

        @Override
        public int getDrawable() {
            return mDrawable;
        }
    }

    public static class IntentAction extends AbstractAction {
        private Context mContext;
        private Intent mIntent;

        public IntentAction(Context context, Intent intent, int drawble) {
            super(drawble);
            this.mContext = context;
            mIntent = intent;
        }

        @Override
        public void performAction(View view) {
            try {
                mContext.startActivity(mIntent);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(mContext,
                        mContext.getText(R.string.actionbar_activity_not_found),
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
}







