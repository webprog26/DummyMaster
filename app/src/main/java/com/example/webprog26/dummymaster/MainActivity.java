package com.example.webprog26.dummymaster;

import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.tv_text)
    TextView mTvText;

    @BindView(R.id.iv_image)
    ImageView mIvImage;

    @BindView(R.id.btn_click)
    Button mBtnClick;

    private boolean hasImage = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getBtnClick().setOnClickListener(this);
    }

    public TextView getTvText() {
        return mTvText;
    }

    public ImageView getIvImage() {
        return mIvImage;
    }

    public Button getBtnClick() {
        return mBtnClick;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btn_click:

                final String dummyText = getString(R.string.dummy_text);
                final TextView mainTextView = getTvText();
                final ImageView mainImageView = getIvImage();

                String currentText = mainTextView.getText().toString();

                        getTvText().setText((currentText == null || currentText.equals("")) ? dummyText : "");

                        if(!isHasImage()) {
                            mainImageView.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
                        } else {
                            mainImageView.setImageBitmap(null);
                        }

                        setHasImage(!isHasImage());

                break;
        }

    }

    public boolean isHasImage() {
        return hasImage;
    }

    public void setHasImage(boolean hasImage) {
        this.hasImage = hasImage;
    }
}
