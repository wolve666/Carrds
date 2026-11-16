package it.educk.carrds;

import android.os.Bundle;
import com.getcapacitor.BridgeActivity;

public class MainActivity extends BridgeActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        registerPlugin(CarrdsPlugin.class);
        super.onCreate(savedInstanceState);
    }
}
