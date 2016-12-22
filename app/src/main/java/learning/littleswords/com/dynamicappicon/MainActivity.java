package learning.littleswords.com.dynamicappicon;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    private ComponentName normalIconLauncher;
    private ComponentName modifyIconLauncher;
    private PackageManager mPm;
    private ComponentName defaultComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        normalIconLauncher = new ComponentName(getBaseContext(), "learning.littleswords.com.dynamicappicon.alias1");
        modifyIconLauncher= new ComponentName(this, "learning.littleswords.com.dynamicappicon.alias2");
        defaultComponent = getComponentName();
        mPm = getPackageManager();

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enableComponent(normalIconLauncher);
                disableComponent(defaultComponent);
                disableComponent(modifyIconLauncher);
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disableComponent(normalIconLauncher);
                disableComponent(defaultComponent);
                enableComponent(modifyIconLauncher);
            }
        });
    }

    private void enableComponent(ComponentName componentName) {
        mPm.setComponentEnabledSetting(componentName,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);
    }

    private void disableComponent(ComponentName componentName) {
        mPm.setComponentEnabledSetting(componentName,
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP);
    }
}
