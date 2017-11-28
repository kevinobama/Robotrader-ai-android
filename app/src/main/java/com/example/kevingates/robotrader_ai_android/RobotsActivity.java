package com.example.kevingates.robotrader_ai_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class RobotsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_robots);

        robotList();
        putDataToListViewMultipleColumns();
    }


    public void robotList()
    {

    }

    public void putDataToListViewMultipleColumns()
    {
        try {
            ArrayList<robotsModel> robots = new ArrayList<robotsModel>();

            String jsonStr = robotJsonData();

            JSONArray contacts = new JSONArray(jsonStr);

            for (int i = 0; i < contacts.length(); i++) {
                JSONObject c = contacts.getJSONObject(i);

                String id = c.getString("id");
                String name = c.getString("name");
                String type = c.getString("robot_type");
                Log.e("JSON Parser name", name);

                robots.add(new robotsModel(id+name+type));
            }

            CustomCryptoAdapter adapter = new CustomCryptoAdapter(this, robots);

            ListView listView = (ListView) findViewById(R.id.robotlistView);
            listView.setAdapter(adapter);
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }
    }

    public String robotJsonData()
    {
        return "[\n" +
                "    {\n" +
                "        \"id\": 404,\n" +
                "        \"robot_type\": \"Ladder Up\",\n" +
                "        \"game_only\": 0,\n" +
                "        \"name\": \"1\",\n" +
                "        \"friendly\": null,\n" +
                "        \"params\": \"{\\\"account_id\\\":null,\\\"pair\\\":null,\\\"increment\\\":\\\"1\\\",\\\"start_buying_percent\\\":\\\"1\\\",\\\"start_buying_minutes\\\":\\\"5\\\",\\\"stop_buying_percent\\\":\\\"2\\\",\\\"stop_buying_minutes\\\":\\\"5\\\",\\\"max_qty_risk\\\":\\\"1\\\",\\\"sellback_percent\\\":\\\"1\\\",\\\"sellback_minutes\\\":\\\"30\\\",\\\"upper_price_limit\\\":\\\"1\\\"}\",\n" +
                "        \"current_status\": \"on\",\n" +
                "        \"current_state\": \"indeterminate\",\n" +
                "        \"action_trigger\": null,\n" +
                "        \"trigger_counter\": null,\n" +
                "        \"action_alert\": null,\n" +
                "        \"last_state_change\": null,\n" +
                "        \"last_action_executed\": null,\n" +
                "        \"uniqid\": null,\n" +
                "        \"deleted_on\": null,\n" +
                "        \"last_state_known\": null,\n" +
                "        \"last_robot_evaluation\": null,\n" +
                "        \"last_state_change_group\": null,\n" +
                "        \"pushover_sound\": null,\n" +
                "        \"action_email\": null,\n" +
                "        \"action_notification_backoff\": null,\n" +
                "        \"action_activate\": null,\n" +
                "        \"action_trade\": null,\n" +
                "        \"action_trade_backoff\": null,\n" +
                "        \"user_id\": 1,\n" +
                "        \"created_at\": \"2017-11-27 09:06:17\",\n" +
                "        \"updated_at\": \"2017-11-27 09:06:17\",\n" +
                "        \"last_state_change_data\": null,\n" +
                "        \"robot_team\": null,\n" +
                "        \"robot_actions\": [\n" +
                "            {\n" +
                "                \"id\": 333,\n" +
                "                \"user_id\": 1,\n" +
                "                \"robot_id\": 404,\n" +
                "                \"trigger\": \"state_change\",\n" +
                "                \"action_table\": \"robot_action_pushover\",\n" +
                "                \"action_id\": 234,\n" +
                "                \"status\": \"active\",\n" +
                "                \"backoff\": 5,\n" +
                "                \"created_at\": \"2017-11-27 09:06:17\",\n" +
                "                \"updated_at\": \"2017-11-27 09:06:17\",\n" +
                "                \"actionable\": {\n" +
                "                    \"id\": 234,\n" +
                "                    \"user_id\": 1,\n" +
                "                    \"robot_id\": 404,\n" +
                "                    \"linked_email_robot_action_id\": null,\n" +
                "                    \"priority\": 1,\n" +
                "                    \"sound\": \"falling\",\n" +
                "                    \"backoff_seconds\": 3600,\n" +
                "                    \"msg_stub\": \"notification.robot_status_change_msg_pushover\",\n" +
                "                    \"created_at\": \"2017-11-27 09:06:17\",\n" +
                "                    \"updated_at\": \"2017-11-27 09:06:17\"\n" +
                "                }\n" +
                "            }\n" +
                "        ],\n" +
                "        \"description\": \"description Ladder Up\",\n" +
                "        \"buttons\": \"<a href='' onclick=\\\"return changeState(404);\\\"><i class='fa fa-pause' title='Pause'></i></a>&nbsp;&nbsp;<a href='' onclick=\\\"return flipDelete(404);\\\"><i class='fa fa-trash-o' title='Delete'></i></a>&nbsp;&nbsp;\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 403,\n" +
                "        \"robot_type\": \"Ladder Down\",\n" +
                "        \"game_only\": 0,\n" +
                "        \"name\": \"1\",\n" +
                "        \"friendly\": null,\n" +
                "        \"params\": \"{\\\"account_id\\\":\\\"32\\\",\\\"pair\\\":\\\"LTC_BTC\\\",\\\"increment\\\":\\\"1\\\",\\\"start_selling_percent\\\":\\\"1\\\",\\\"start_selling_minutes\\\":\\\"5\\\",\\\"stop_selling_percent\\\":\\\"2\\\",\\\"stop_selling_minutes\\\":\\\"2\\\",\\\"max_qty_risk\\\":\\\"1\\\",\\\"buyback_percent\\\":\\\"1\\\",\\\"buyback_minutes\\\":\\\"30\\\",\\\"lower_price_limit\\\":\\\"1\\\"}\",\n" +
                "        \"current_status\": \"on\",\n" +
                "        \"current_state\": \"indeterminate\",\n" +
                "        \"action_trigger\": null,\n" +
                "        \"trigger_counter\": null,\n" +
                "        \"action_alert\": null,\n" +
                "        \"last_state_change\": null,\n" +
                "        \"last_action_executed\": null,\n" +
                "        \"uniqid\": null,\n" +
                "        \"deleted_on\": null,\n" +
                "        \"last_state_known\": null,\n" +
                "        \"last_robot_evaluation\": null,\n" +
                "        \"last_state_change_group\": null,\n" +
                "        \"pushover_sound\": null,\n" +
                "        \"action_email\": null,\n" +
                "        \"action_notification_backoff\": null,\n" +
                "        \"action_activate\": null,\n" +
                "        \"action_trade\": null,\n" +
                "        \"action_trade_backoff\": null,\n" +
                "        \"user_id\": 1,\n" +
                "        \"created_at\": \"2017-11-27 09:03:03\",\n" +
                "        \"updated_at\": \"2017-11-27 09:03:03\",\n" +
                "        \"last_state_change_data\": null,\n" +
                "        \"robot_team\": null,\n" +
                "        \"robot_actions\": [\n" +
                "            {\n" +
                "                \"id\": 332,\n" +
                "                \"user_id\": 1,\n" +
                "                \"robot_id\": 403,\n" +
                "                \"trigger\": \"state_change\",\n" +
                "                \"action_table\": \"robot_action_pushover\",\n" +
                "                \"action_id\": 233,\n" +
                "                \"status\": \"active\",\n" +
                "                \"backoff\": 5,\n" +
                "                \"created_at\": \"2017-11-27 09:03:03\",\n" +
                "                \"updated_at\": \"2017-11-27 09:03:03\",\n" +
                "                \"actionable\": {\n" +
                "                    \"id\": 233,\n" +
                "                    \"user_id\": 1,\n" +
                "                    \"robot_id\": 403,\n" +
                "                    \"linked_email_robot_action_id\": null,\n" +
                "                    \"priority\": 1,\n" +
                "                    \"sound\": \"falling\",\n" +
                "                    \"backoff_seconds\": 3600,\n" +
                "                    \"msg_stub\": \"notification.robot_status_change_msg_pushover\",\n" +
                "                    \"created_at\": \"2017-11-27 09:03:03\",\n" +
                "                    \"updated_at\": \"2017-11-27 09:03:03\"\n" +
                "                }\n" +
                "            }\n" +
                "        ],\n" +
                "        \"description\": \"description Ladder Down\",\n" +
                "        \"buttons\": \"<a href='' onclick=\\\"return changeState(403);\\\"><i class='fa fa-pause' title='Pause'></i></a>&nbsp;&nbsp;<a href='' onclick=\\\"return flipDelete(403);\\\"><i class='fa fa-trash-o' title='Delete'></i></a>&nbsp;&nbsp;\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 402,\n" +
                "        \"robot_type\": \"Ladder Up\",\n" +
                "        \"game_only\": 0,\n" +
                "        \"name\": \"2\",\n" +
                "        \"friendly\": null,\n" +
                "        \"params\": \"{\\\"account_id\\\":null,\\\"pair\\\":null,\\\"increment\\\":\\\"2\\\",\\\"start_buying_percent\\\":\\\"2\\\",\\\"start_buying_minutes\\\":\\\"2\\\",\\\"stop_buying_percent\\\":\\\"2\\\",\\\"stop_buying_minutes\\\":\\\"2\\\",\\\"max_qty_risk\\\":\\\"2\\\",\\\"sellback_percent\\\":\\\"2\\\",\\\"sellback_minutes\\\":\\\"60\\\",\\\"upper_price_limit\\\":\\\"2\\\"}\",\n" +
                "        \"current_status\": \"on\",\n" +
                "        \"current_state\": \"indeterminate\",\n" +
                "        \"action_trigger\": null,\n" +
                "        \"trigger_counter\": null,\n" +
                "        \"action_alert\": null,\n" +
                "        \"last_state_change\": null,\n" +
                "        \"last_action_executed\": null,\n" +
                "        \"uniqid\": null,\n" +
                "        \"deleted_on\": null,\n" +
                "        \"last_state_known\": null,\n" +
                "        \"last_robot_evaluation\": null,\n" +
                "        \"last_state_change_group\": null,\n" +
                "        \"pushover_sound\": null,\n" +
                "        \"action_email\": null,\n" +
                "        \"action_notification_backoff\": null,\n" +
                "        \"action_activate\": null,\n" +
                "        \"action_trade\": null,\n" +
                "        \"action_trade_backoff\": null,\n" +
                "        \"user_id\": 1,\n" +
                "        \"created_at\": \"2017-11-27 08:35:03\",\n" +
                "        \"updated_at\": \"2017-11-27 08:35:03\",\n" +
                "        \"last_state_change_data\": null,\n" +
                "        \"robot_team\": null,\n" +
                "        \"robot_actions\": [\n" +
                "            {\n" +
                "                \"id\": 331,\n" +
                "                \"user_id\": 1,\n" +
                "                \"robot_id\": 402,\n" +
                "                \"trigger\": \"state_change\",\n" +
                "                \"action_table\": \"robot_action_pushover\",\n" +
                "                \"action_id\": 232,\n" +
                "                \"status\": \"active\",\n" +
                "                \"backoff\": 5,\n" +
                "                \"created_at\": \"2017-11-27 08:35:03\",\n" +
                "                \"updated_at\": \"2017-11-27 08:35:03\",\n" +
                "                \"actionable\": {\n" +
                "                    \"id\": 232,\n" +
                "                    \"user_id\": 1,\n" +
                "                    \"robot_id\": 402,\n" +
                "                    \"linked_email_robot_action_id\": null,\n" +
                "                    \"priority\": 1,\n" +
                "                    \"sound\": \"falling\",\n" +
                "                    \"backoff_seconds\": 3600,\n" +
                "                    \"msg_stub\": \"notification.robot_status_change_msg_pushover\",\n" +
                "                    \"created_at\": \"2017-11-27 08:35:03\",\n" +
                "                    \"updated_at\": \"2017-11-27 08:35:03\"\n" +
                "                }\n" +
                "            }\n" +
                "        ],\n" +
                "        \"description\": \"description Ladder Up\",\n" +
                "        \"buttons\": \"<a href='' onclick=\\\"return changeState(402);\\\"><i class='fa fa-pause' title='Pause'></i></a>&nbsp;&nbsp;<a href='' onclick=\\\"return flipDelete(402);\\\"><i class='fa fa-trash-o' title='Delete'></i></a>&nbsp;&nbsp;\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 401,\n" +
                "        \"robot_type\": \"Ladder Down\",\n" +
                "        \"game_only\": 0,\n" +
                "        \"name\": \"1\",\n" +
                "        \"friendly\": null,\n" +
                "        \"params\": \"{\\\"account_id\\\":\\\"39\\\",\\\"pair\\\":\\\"BTC_CNY\\\",\\\"increment\\\":\\\"1\\\",\\\"start_selling_percent\\\":\\\"1\\\",\\\"start_selling_minutes\\\":\\\"2\\\",\\\"stop_selling_percent\\\":\\\"1\\\",\\\"stop_selling_minutes\\\":\\\"2\\\",\\\"max_qty_risk\\\":\\\"1\\\",\\\"buyback_percent\\\":\\\"1\\\",\\\"buyback_minutes\\\":\\\"2\\\",\\\"lower_price_limit\\\":\\\"1\\\"}\",\n" +
                "        \"current_status\": \"on\",\n" +
                "        \"current_state\": \"indeterminate\",\n" +
                "        \"action_trigger\": null,\n" +
                "        \"trigger_counter\": null,\n" +
                "        \"action_alert\": null,\n" +
                "        \"last_state_change\": null,\n" +
                "        \"last_action_executed\": null,\n" +
                "        \"uniqid\": null,\n" +
                "        \"deleted_on\": null,\n" +
                "        \"last_state_known\": null,\n" +
                "        \"last_robot_evaluation\": null,\n" +
                "        \"last_state_change_group\": null,\n" +
                "        \"pushover_sound\": null,\n" +
                "        \"action_email\": null,\n" +
                "        \"action_notification_backoff\": null,\n" +
                "        \"action_activate\": null,\n" +
                "        \"action_trade\": null,\n" +
                "        \"action_trade_backoff\": null,\n" +
                "        \"user_id\": 1,\n" +
                "        \"created_at\": \"2017-11-27 08:25:12\",\n" +
                "        \"updated_at\": \"2017-11-27 08:25:12\",\n" +
                "        \"last_state_change_data\": null,\n" +
                "        \"robot_team\": null,\n" +
                "        \"robot_actions\": [\n" +
                "            {\n" +
                "                \"id\": 330,\n" +
                "                \"user_id\": 1,\n" +
                "                \"robot_id\": 401,\n" +
                "                \"trigger\": \"state_change\",\n" +
                "                \"action_table\": \"robot_action_pushover\",\n" +
                "                \"action_id\": 231,\n" +
                "                \"status\": \"active\",\n" +
                "                \"backoff\": 5,\n" +
                "                \"created_at\": \"2017-11-27 08:25:12\",\n" +
                "                \"updated_at\": \"2017-11-27 08:25:12\",\n" +
                "                \"actionable\": {\n" +
                "                    \"id\": 231,\n" +
                "                    \"user_id\": 1,\n" +
                "                    \"robot_id\": 401,\n" +
                "                    \"linked_email_robot_action_id\": null,\n" +
                "                    \"priority\": 1,\n" +
                "                    \"sound\": \"falling\",\n" +
                "                    \"backoff_seconds\": 3600,\n" +
                "                    \"msg_stub\": \"notification.robot_status_change_msg_pushover\",\n" +
                "                    \"created_at\": \"2017-11-27 08:25:12\",\n" +
                "                    \"updated_at\": \"2017-11-27 08:25:12\"\n" +
                "                }\n" +
                "            }\n" +
                "        ],\n" +
                "        \"description\": \"description Ladder Down\",\n" +
                "        \"buttons\": \"<a href='' onclick=\\\"return changeState(401);\\\"><i class='fa fa-pause' title='Pause'></i></a>&nbsp;&nbsp;<a href='' onclick=\\\"return flipDelete(401);\\\"><i class='fa fa-trash-o' title='Delete'></i></a>&nbsp;&nbsp;\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 400,\n" +
                "        \"robot_type\": \"Simple Arbitrator\",\n" +
                "        \"game_only\": 0,\n" +
                "        \"name\": \"1\",\n" +
                "        \"friendly\": null,\n" +
                "        \"params\": \"{\\\"pair\\\":\\\"BTC_CNY\\\",\\\"exchange1\\\":\\\"5\\\",\\\"exchange2\\\":\\\"5\\\",\\\"arbitrate\\\":\\\"1\\\",\\\"rebalance_loss\\\":\\\"1\\\",\\\"increment\\\":\\\"1\\\",\\\"minimum_balances\\\":[{\\\"exchange\\\":\\\"56\\\",\\\"currency\\\":\\\"EUR\\\",\\\"balance\\\":\\\"1\\\"}]}\",\n" +
                "        \"current_status\": \"on\",\n" +
                "        \"current_state\": \"indeterminate\",\n" +
                "        \"action_trigger\": null,\n" +
                "        \"trigger_counter\": null,\n" +
                "        \"action_alert\": null,\n" +
                "        \"last_state_change\": null,\n" +
                "        \"last_action_executed\": null,\n" +
                "        \"uniqid\": null,\n" +
                "        \"deleted_on\": null,\n" +
                "        \"last_state_known\": null,\n" +
                "        \"last_robot_evaluation\": null,\n" +
                "        \"last_state_change_group\": null,\n" +
                "        \"pushover_sound\": null,\n" +
                "        \"action_email\": null,\n" +
                "        \"action_notification_backoff\": null,\n" +
                "        \"action_activate\": null,\n" +
                "        \"action_trade\": null,\n" +
                "        \"action_trade_backoff\": null,\n" +
                "        \"user_id\": 1,\n" +
                "        \"created_at\": \"2017-11-27 01:57:27\",\n" +
                "        \"updated_at\": \"2017-11-27 01:57:27\",\n" +
                "        \"last_state_change_data\": null,\n" +
                "        \"robot_team\": null,\n" +
                "        \"robot_actions\": [\n" +
                "            {\n" +
                "                \"id\": 329,\n" +
                "                \"user_id\": 1,\n" +
                "                \"robot_id\": 400,\n" +
                "                \"trigger\": \"state_change\",\n" +
                "                \"action_table\": \"robot_action_pushover\",\n" +
                "                \"action_id\": 230,\n" +
                "                \"status\": \"active\",\n" +
                "                \"backoff\": 5,\n" +
                "                \"created_at\": \"2017-11-27 01:57:27\",\n" +
                "                \"updated_at\": \"2017-11-27 01:57:27\",\n" +
                "                \"actionable\": {\n" +
                "                    \"id\": 230,\n" +
                "                    \"user_id\": 1,\n" +
                "                    \"robot_id\": 400,\n" +
                "                    \"linked_email_robot_action_id\": null,\n" +
                "                    \"priority\": 1,\n" +
                "                    \"sound\": \"falling\",\n" +
                "                    \"backoff_seconds\": 3600,\n" +
                "                    \"msg_stub\": \"notification.robot_status_change_msg_pushover\",\n" +
                "                    \"created_at\": \"2017-11-27 01:57:27\",\n" +
                "                    \"updated_at\": \"2017-11-27 01:57:27\"\n" +
                "                }\n" +
                "            }\n" +
                "        ],\n" +
                "        \"description\": \"Arbitrate BTC_CNY between Huobi and Huobi at 1% price difference less max rebalancing loss 1%\",\n" +
                "        \"buttons\": \"<a href='' onclick=\\\"return changeState(400);\\\"><i class='fa fa-pause' title='Pause'></i></a>&nbsp;&nbsp;<a href='' onclick=\\\"return flipDelete(400);\\\"><i class='fa fa-trash-o' title='Delete'></i></a>&nbsp;&nbsp;\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 399,\n" +
                "        \"robot_type\": \"Simple Arbitrator\",\n" +
                "        \"game_only\": 0,\n" +
                "        \"name\": \"1\",\n" +
                "        \"friendly\": null,\n" +
                "        \"params\": \"{\\\"pair\\\":\\\"BTC_USD\\\",\\\"exchange1\\\":\\\"3\\\",\\\"exchange2\\\":\\\"13\\\",\\\"arbitrate\\\":\\\"11\\\",\\\"rebalance_loss\\\":\\\"1\\\",\\\"increment\\\":\\\"1\\\",\\\"minimum_balances\\\":[]}\",\n" +
                "        \"current_status\": \"on\",\n" +
                "        \"current_state\": \"indeterminate\",\n" +
                "        \"action_trigger\": null,\n" +
                "        \"trigger_counter\": null,\n" +
                "        \"action_alert\": null,\n" +
                "        \"last_state_change\": null,\n" +
                "        \"last_action_executed\": null,\n" +
                "        \"uniqid\": null,\n" +
                "        \"deleted_on\": null,\n" +
                "        \"last_state_known\": null,\n" +
                "        \"last_robot_evaluation\": null,\n" +
                "        \"last_state_change_group\": null,\n" +
                "        \"pushover_sound\": null,\n" +
                "        \"action_email\": null,\n" +
                "        \"action_notification_backoff\": null,\n" +
                "        \"action_activate\": null,\n" +
                "        \"action_trade\": null,\n" +
                "        \"action_trade_backoff\": null,\n" +
                "        \"user_id\": 1,\n" +
                "        \"created_at\": \"2017-11-24 05:39:51\",\n" +
                "        \"updated_at\": \"2017-11-24 05:39:51\",\n" +
                "        \"last_state_change_data\": null,\n" +
                "        \"robot_team\": null,\n" +
                "        \"robot_actions\": [\n" +
                "            {\n" +
                "                \"id\": 328,\n" +
                "                \"user_id\": 1,\n" +
                "                \"robot_id\": 399,\n" +
                "                \"trigger\": \"false_true\",\n" +
                "                \"action_table\": \"robot_action_pushover\",\n" +
                "                \"action_id\": 229,\n" +
                "                \"status\": \"active\",\n" +
                "                \"backoff\": 0,\n" +
                "                \"created_at\": \"2017-11-24 05:39:51\",\n" +
                "                \"updated_at\": \"2017-11-27 01:57:02\",\n" +
                "                \"actionable\": {\n" +
                "                    \"id\": 229,\n" +
                "                    \"user_id\": 1,\n" +
                "                    \"robot_id\": 399,\n" +
                "                    \"linked_email_robot_action_id\": null,\n" +
                "                    \"priority\": 1,\n" +
                "                    \"sound\": \"falling\",\n" +
                "                    \"backoff_seconds\": 3600,\n" +
                "                    \"msg_stub\": \"notification.robot_status_change_msg_pushover\",\n" +
                "                    \"created_at\": \"2017-11-24 05:39:51\",\n" +
                "                    \"updated_at\": \"2017-11-24 05:39:51\"\n" +
                "                }\n" +
                "            }\n" +
                "        ],\n" +
                "        \"description\": \"Arbitrate BTC_USD between OKCoin International and Poloniex at 11% price difference less max rebalancing loss 1%\",\n" +
                "        \"buttons\": \"<a href='' onclick=\\\"return changeState(399);\\\"><i class='fa fa-pause' title='Pause'></i></a>&nbsp;&nbsp;<a href='' onclick=\\\"return flipDelete(399);\\\"><i class='fa fa-trash-o' title='Delete'></i></a>&nbsp;&nbsp;\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 398,\n" +
                "        \"robot_type\": \"Simple Arbitrator\",\n" +
                "        \"game_only\": 0,\n" +
                "        \"name\": \"1\",\n" +
                "        \"friendly\": null,\n" +
                "        \"params\": \"{\\\"pair\\\":\\\"BTC_USD\\\",\\\"exchange1\\\":\\\"4\\\",\\\"exchange2\\\":\\\"4\\\",\\\"arbitrate\\\":\\\"1\\\",\\\"rebalance_loss\\\":\\\"1\\\",\\\"increment\\\":\\\"1\\\",\\\"minimum_balances\\\":[{\\\"exchange\\\":\\\"13\\\",\\\"currency\\\":\\\"BTC\\\",\\\"balance\\\":\\\"1\\\"},{\\\"exchange\\\":\\\"56\\\",\\\"currency\\\":\\\"USD\\\",\\\"balance\\\":\\\"1\\\"}]}\",\n" +
                "        \"current_status\": \"on\",\n" +
                "        \"current_state\": \"indeterminate\",\n" +
                "        \"action_trigger\": null,\n" +
                "        \"trigger_counter\": null,\n" +
                "        \"action_alert\": null,\n" +
                "        \"last_state_change\": null,\n" +
                "        \"last_action_executed\": null,\n" +
                "        \"uniqid\": null,\n" +
                "        \"deleted_on\": null,\n" +
                "        \"last_state_known\": null,\n" +
                "        \"last_robot_evaluation\": null,\n" +
                "        \"last_state_change_group\": null,\n" +
                "        \"pushover_sound\": null,\n" +
                "        \"action_email\": null,\n" +
                "        \"action_notification_backoff\": null,\n" +
                "        \"action_activate\": null,\n" +
                "        \"action_trade\": null,\n" +
                "        \"action_trade_backoff\": null,\n" +
                "        \"user_id\": 1,\n" +
                "        \"created_at\": \"2017-11-23 10:34:14\",\n" +
                "        \"updated_at\": \"2017-11-23 10:34:14\",\n" +
                "        \"last_state_change_data\": null,\n" +
                "        \"robot_team\": null,\n" +
                "        \"robot_actions\": [\n" +
                "            {\n" +
                "                \"id\": 327,\n" +
                "                \"user_id\": 1,\n" +
                "                \"robot_id\": 398,\n" +
                "                \"trigger\": \"state_change\",\n" +
                "                \"action_table\": \"robot_action_pushover\",\n" +
                "                \"action_id\": 228,\n" +
                "                \"status\": \"active\",\n" +
                "                \"backoff\": 5,\n" +
                "                \"created_at\": \"2017-11-23 10:34:14\",\n" +
                "                \"updated_at\": \"2017-11-23 10:34:14\",\n" +
                "                \"actionable\": {\n" +
                "                    \"id\": 228,\n" +
                "                    \"user_id\": 1,\n" +
                "                    \"robot_id\": 398,\n" +
                "                    \"linked_email_robot_action_id\": null,\n" +
                "                    \"priority\": 1,\n" +
                "                    \"sound\": \"falling\",\n" +
                "                    \"backoff_seconds\": 3600,\n" +
                "                    \"msg_stub\": \"notification.robot_status_change_msg_pushover\",\n" +
                "                    \"created_at\": \"2017-11-23 10:34:14\",\n" +
                "                    \"updated_at\": \"2017-11-23 10:34:14\"\n" +
                "                }\n" +
                "            }\n" +
                "        ],\n" +
                "        \"description\": \"Arbitrate BTC_USD between Bitfinex (Exchange) and Bitfinex (Exchange) at 1% price difference less max rebalancing loss 1%\",\n" +
                "        \"buttons\": \"<a href='' onclick=\\\"return changeState(398);\\\"><i class='fa fa-pause' title='Pause'></i></a>&nbsp;&nbsp;<a href='' onclick=\\\"return flipDelete(398);\\\"><i class='fa fa-trash-o' title='Delete'></i></a>&nbsp;&nbsp;\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 397,\n" +
                "        \"robot_type\": \"Simple Arbitrator\",\n" +
                "        \"game_only\": 0,\n" +
                "        \"name\": \"1\",\n" +
                "        \"friendly\": null,\n" +
                "        \"params\": \"{\\\"name\\\":\\\"1\\\",\\\"pair\\\":\\\"LTC_CNY\\\",\\\"exchange1\\\":\\\"5\\\",\\\"exchange2\\\":\\\"24\\\",\\\"arbitrate\\\":\\\"11\\\",\\\"rebalance_loss\\\":\\\"1\\\",\\\"increment\\\":\\\"1\\\",\\\"minimum_balances\\\":[]}\",\n" +
                "        \"current_status\": \"on\",\n" +
                "        \"current_state\": \"indeterminate\",\n" +
                "        \"action_trigger\": null,\n" +
                "        \"trigger_counter\": null,\n" +
                "        \"action_alert\": null,\n" +
                "        \"last_state_change\": null,\n" +
                "        \"last_action_executed\": null,\n" +
                "        \"uniqid\": null,\n" +
                "        \"deleted_on\": null,\n" +
                "        \"last_state_known\": null,\n" +
                "        \"last_robot_evaluation\": null,\n" +
                "        \"last_state_change_group\": null,\n" +
                "        \"pushover_sound\": null,\n" +
                "        \"action_email\": null,\n" +
                "        \"action_notification_backoff\": null,\n" +
                "        \"action_activate\": null,\n" +
                "        \"action_trade\": null,\n" +
                "        \"action_trade_backoff\": null,\n" +
                "        \"user_id\": 1,\n" +
                "        \"created_at\": \"2017-11-23 10:09:12\",\n" +
                "        \"updated_at\": \"2017-11-23 10:09:12\",\n" +
                "        \"last_state_change_data\": null,\n" +
                "        \"robot_team\": null,\n" +
                "        \"robot_actions\": [\n" +
                "            {\n" +
                "                \"id\": 326,\n" +
                "                \"user_id\": 1,\n" +
                "                \"robot_id\": 397,\n" +
                "                \"trigger\": \"state_change\",\n" +
                "                \"action_table\": \"robot_action_pushover\",\n" +
                "                \"action_id\": 227,\n" +
                "                \"status\": \"active\",\n" +
                "                \"backoff\": 5,\n" +
                "                \"created_at\": \"2017-11-23 10:09:12\",\n" +
                "                \"updated_at\": \"2017-11-23 10:09:12\",\n" +
                "                \"actionable\": {\n" +
                "                    \"id\": 227,\n" +
                "                    \"user_id\": 1,\n" +
                "                    \"robot_id\": 397,\n" +
                "                    \"linked_email_robot_action_id\": null,\n" +
                "                    \"priority\": 1,\n" +
                "                    \"sound\": \"falling\",\n" +
                "                    \"backoff_seconds\": 3600,\n" +
                "                    \"msg_stub\": \"notification.robot_status_change_msg_pushover\",\n" +
                "                    \"created_at\": \"2017-11-23 10:09:12\",\n" +
                "                    \"updated_at\": \"2017-11-23 10:09:12\"\n" +
                "                }\n" +
                "            }\n" +
                "        ],\n" +
                "        \"description\": \"Arbitrate LTC_CNY between Huobi and Gemini at 11% price difference less max rebalancing loss 1%\",\n" +
                "        \"buttons\": \"<a href='' onclick=\\\"return changeState(397);\\\"><i class='fa fa-pause' title='Pause'></i></a>&nbsp;&nbsp;<a href='' onclick=\\\"return flipDelete(397);\\\"><i class='fa fa-trash-o' title='Delete'></i></a>&nbsp;&nbsp;\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 391,\n" +
                "        \"robot_type\": \"Price Level\",\n" +
                "        \"game_only\": 0,\n" +
                "        \"name\": \"University-946\",\n" +
                "        \"friendly\": null,\n" +
                "        \"params\": \"{\\\"side\\\":null,\\\"qty\\\":null,\\\"pairA\\\":\\\"\\\",\\\"pairB\\\":\\\"\\\",\\\"pair\\\":\\\"_\\\",\\\"exchange\\\":null,\\\"position\\\":null,\\\"price\\\":null}\",\n" +
                "        \"current_status\": \"on\",\n" +
                "        \"current_state\": \"indeterminate\",\n" +
                "        \"action_trigger\": null,\n" +
                "        \"trigger_counter\": null,\n" +
                "        \"action_alert\": null,\n" +
                "        \"last_state_change\": null,\n" +
                "        \"last_action_executed\": null,\n" +
                "        \"uniqid\": null,\n" +
                "        \"deleted_on\": null,\n" +
                "        \"last_state_known\": null,\n" +
                "        \"last_robot_evaluation\": null,\n" +
                "        \"last_state_change_group\": null,\n" +
                "        \"pushover_sound\": null,\n" +
                "        \"action_email\": null,\n" +
                "        \"action_notification_backoff\": null,\n" +
                "        \"action_activate\": null,\n" +
                "        \"action_trade\": null,\n" +
                "        \"action_trade_backoff\": null,\n" +
                "        \"user_id\": 1,\n" +
                "        \"created_at\": \"2017-11-21 07:29:20\",\n" +
                "        \"updated_at\": \"2017-11-21 07:29:20\",\n" +
                "        \"last_state_change_data\": null,\n" +
                "        \"robot_team\": null,\n" +
                "        \"robot_actions\": [\n" +
                "            {\n" +
                "                \"id\": 320,\n" +
                "                \"user_id\": 1,\n" +
                "                \"robot_id\": 391,\n" +
                "                \"trigger\": \"state_change\",\n" +
                "                \"action_table\": \"robot_action_pushover\",\n" +
                "                \"action_id\": 221,\n" +
                "                \"status\": \"active\",\n" +
                "                \"backoff\": 5,\n" +
                "                \"created_at\": \"2017-11-21 07:29:20\",\n" +
                "                \"updated_at\": \"2017-11-21 07:29:20\",\n" +
                "                \"actionable\": {\n" +
                "                    \"id\": 221,\n" +
                "                    \"user_id\": 1,\n" +
                "                    \"robot_id\": 391,\n" +
                "                    \"linked_email_robot_action_id\": null,\n" +
                "                    \"priority\": 1,\n" +
                "                    \"sound\": \"falling\",\n" +
                "                    \"backoff_seconds\": 3600,\n" +
                "                    \"msg_stub\": \"notification.robot_status_change_msg_pushover\",\n" +
                "                    \"created_at\": \"2017-11-21 07:29:20\",\n" +
                "                    \"updated_at\": \"2017-11-21 07:29:20\"\n" +
                "                }\n" +
                "            }\n" +
                "        ],\n" +
                "        \"description\": \"Price to    on  is   \",\n" +
                "        \"buttons\": \"<a href='' onclick=\\\"return changeState(391);\\\"><i class='fa fa-pause' title='Pause'></i></a>&nbsp;&nbsp;<a href='' onclick=\\\"return flipDelete(391);\\\"><i class='fa fa-trash-o' title='Delete'></i></a>&nbsp;&nbsp;\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 390,\n" +
                "        \"robot_type\": \"Price Level\",\n" +
                "        \"game_only\": 0,\n" +
                "        \"name\": \"Postbox-350\",\n" +
                "        \"friendly\": null,\n" +
                "        \"params\": \"{\\\"side\\\":null,\\\"qty\\\":null,\\\"pairA\\\":\\\"\\\",\\\"pairB\\\":\\\"\\\",\\\"pair\\\":\\\"_\\\",\\\"exchange\\\":null,\\\"position\\\":null,\\\"price\\\":null}\",\n" +
                "        \"current_status\": \"on\",\n" +
                "        \"current_state\": \"indeterminate\",\n" +
                "        \"action_trigger\": null,\n" +
                "        \"trigger_counter\": null,\n" +
                "        \"action_alert\": null,\n" +
                "        \"last_state_change\": null,\n" +
                "        \"last_action_executed\": null,\n" +
                "        \"uniqid\": null,\n" +
                "        \"deleted_on\": null,\n" +
                "        \"last_state_known\": null,\n" +
                "        \"last_robot_evaluation\": null,\n" +
                "        \"last_state_change_group\": null,\n" +
                "        \"pushover_sound\": null,\n" +
                "        \"action_email\": null,\n" +
                "        \"action_notification_backoff\": null,\n" +
                "        \"action_activate\": null,\n" +
                "        \"action_trade\": null,\n" +
                "        \"action_trade_backoff\": null,\n" +
                "        \"user_id\": 1,\n" +
                "        \"created_at\": \"2017-11-21 07:28:31\",\n" +
                "        \"updated_at\": \"2017-11-21 07:28:31\",\n" +
                "        \"last_state_change_data\": null,\n" +
                "        \"robot_team\": null,\n" +
                "        \"robot_actions\": [\n" +
                "            {\n" +
                "                \"id\": 319,\n" +
                "                \"user_id\": 1,\n" +
                "                \"robot_id\": 390,\n" +
                "                \"trigger\": \"state_change\",\n" +
                "                \"action_table\": \"robot_action_pushover\",\n" +
                "                \"action_id\": 220,\n" +
                "                \"status\": \"active\",\n" +
                "                \"backoff\": 5,\n" +
                "                \"created_at\": \"2017-11-21 07:28:31\",\n" +
                "                \"updated_at\": \"2017-11-21 07:28:31\",\n" +
                "                \"actionable\": {\n" +
                "                    \"id\": 220,\n" +
                "                    \"user_id\": 1,\n" +
                "                    \"robot_id\": 390,\n" +
                "                    \"linked_email_robot_action_id\": null,\n" +
                "                    \"priority\": 1,\n" +
                "                    \"sound\": \"falling\",\n" +
                "                    \"backoff_seconds\": 3600,\n" +
                "                    \"msg_stub\": \"notification.robot_status_change_msg_pushover\",\n" +
                "                    \"created_at\": \"2017-11-21 07:28:31\",\n" +
                "                    \"updated_at\": \"2017-11-21 07:28:31\"\n" +
                "                }\n" +
                "            }\n" +
                "        ],\n" +
                "        \"description\": \"Price to    on  is   \",\n" +
                "        \"buttons\": \"<a href='' onclick=\\\"return changeState(390);\\\"><i class='fa fa-pause' title='Pause'></i></a>&nbsp;&nbsp;<a href='' onclick=\\\"return flipDelete(390);\\\"><i class='fa fa-trash-o' title='Delete'></i></a>&nbsp;&nbsp;\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 383,\n" +
                "        \"robot_type\": \"Price Level\",\n" +
                "        \"game_only\": 0,\n" +
                "        \"name\": \"Embossing-695\",\n" +
                "        \"friendly\": null,\n" +
                "        \"params\": \"{\\\"side\\\":\\\"sell\\\",\\\"qty\\\":\\\"0.5\\\",\\\"pairA\\\":\\\"BCH\\\",\\\"pairB\\\":\\\"USD\\\",\\\"pair\\\":\\\"BCH_USD\\\",\\\"exchange\\\":\\\"1\\\",\\\"position\\\":\\\"above\\\",\\\"price\\\":\\\"1100\\\"}\",\n" +
                "        \"current_status\": \"paused\",\n" +
                "        \"current_state\": \"off\",\n" +
                "        \"action_trigger\": null,\n" +
                "        \"trigger_counter\": null,\n" +
                "        \"action_alert\": null,\n" +
                "        \"last_state_change\": \"2017-11-17 02:56:46\",\n" +
                "        \"last_action_executed\": null,\n" +
                "        \"uniqid\": null,\n" +
                "        \"deleted_on\": null,\n" +
                "        \"last_state_known\": \"false\",\n" +
                "        \"last_robot_evaluation\": \"2017-11-17 02:56:54\",\n" +
                "        \"last_state_change_group\": \"5a0e4fee04b9c7.54533623\",\n" +
                "        \"pushover_sound\": null,\n" +
                "        \"action_email\": null,\n" +
                "        \"action_notification_backoff\": null,\n" +
                "        \"action_activate\": null,\n" +
                "        \"action_trade\": null,\n" +
                "        \"action_trade_backoff\": null,\n" +
                "        \"user_id\": 1,\n" +
                "        \"created_at\": \"2017-11-16 19:23:13\",\n" +
                "        \"updated_at\": \"2017-11-17 10:56:55\",\n" +
                "        \"last_state_change_data\": \"{\\\"new_state\\\":\\\"indeterminate\\\"}\",\n" +
                "        \"robot_team\": null,\n" +
                "        \"robot_actions\": [\n" +
                "            {\n" +
                "                \"id\": 310,\n" +
                "                \"user_id\": 1,\n" +
                "                \"robot_id\": 383,\n" +
                "                \"trigger\": \"false_true\",\n" +
                "                \"action_table\": \"robot_action_pushover\",\n" +
                "                \"action_id\": 213,\n" +
                "                \"status\": \"active\",\n" +
                "                \"backoff\": 0,\n" +
                "                \"created_at\": \"2017-11-16 19:23:14\",\n" +
                "                \"updated_at\": \"2017-11-20 06:35:29\",\n" +
                "                \"actionable\": {\n" +
                "                    \"id\": 213,\n" +
                "                    \"user_id\": 1,\n" +
                "                    \"robot_id\": 383,\n" +
                "                    \"linked_email_robot_action_id\": null,\n" +
                "                    \"priority\": 1,\n" +
                "                    \"sound\": \"climb\",\n" +
                "                    \"backoff_seconds\": 3600,\n" +
                "                    \"msg_stub\": \"notification.robot_status_change_msg_pushover\",\n" +
                "                    \"created_at\": \"2017-11-16 19:23:14\",\n" +
                "                    \"updated_at\": \"2017-11-16 19:23:14\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 311,\n" +
                "                \"user_id\": 1,\n" +
                "                \"robot_id\": 383,\n" +
                "                \"trigger\": \"false_true\",\n" +
                "                \"action_table\": \"robot_action_trade\",\n" +
                "                \"action_id\": 15,\n" +
                "                \"status\": \"active\",\n" +
                "                \"backoff\": 0,\n" +
                "                \"created_at\": \"2017-11-16 19:27:15\",\n" +
                "                \"updated_at\": \"2017-11-16 19:27:15\",\n" +
                "                \"actionable\": {\n" +
                "                    \"id\": 15,\n" +
                "                    \"user_id\": 1,\n" +
                "                    \"robot_id\": 383,\n" +
                "                    \"account_id\": 39,\n" +
                "                    \"exchange_id\": 1,\n" +
                "                    \"side\": \"sell\",\n" +
                "                    \"quantity\": 0.5,\n" +
                "                    \"pair\": \"BCH_USD\",\n" +
                "                    \"created_at\": \"2017-11-16 19:27:15\",\n" +
                "                    \"updated_at\": \"2017-11-16 19:27:15\",\n" +
                "                    \"account\": {\n" +
                "                        \"id\": 39,\n" +
                "                        \"account_label\": \"Kraken\",\n" +
                "                        \"last_four\": \"dJnV\",\n" +
                "                        \"pwd\": \"Gp7CiIm6qLhdU4pira8cwozrLefQ\",\n" +
                "                        \"encryption_level\": \"2\",\n" +
                "                        \"creds\": \"iNrwMIAjTYnoTfLpQsfLHRgVd7y7we8wyrNg6JRrqIX8dbwPmaUeGjbPWgXqZs1w1N581o5Rt/7FvOb0HOx87ulXNDc22M59dM2zVWZcmvHwqUCAOQ3n06/sBVawJo1AZBwR3L6oCg7AYNwobREhQsq6ZjjLIUhIWQygH2KJu3LwFxVMfpLMT7WclU1gYemX6SCR2zkkdTxrGON0nW1zT0oV07EJQmux0KlL3owjuSWS+9nudNoDzfcZh6spMw==\",\n" +
                "                        \"creds_backup\": \"iNrwMIAjTYnoTfLpQsfLHRgVd7y7we8wyrNg6JRrqIX8dbwPmaUeGjbPWgXqZs1w1N581o5Rt/7FvOb0HOx87ulXNDc22M59dM2zVWZcmvHwqUCAOQ3n06/sBVawJo1AZBwR3L6oCg7AYNwobREhQsq6ZjjLIUhIWQygH2KJu3LwFxVMfpLMT7WclU1gYemX6SCR2zkkdTxrGON0nW1zT0oV07EJQmux0KlL3owjuSWS+9nudNoDzfcZh6spMw==\",\n" +
                "                        \"creds_hash\": \"a8798a3e0bb58ae0f260d02450144e5a17df85cfcbadb6bbb136d42fdc07237b\",\n" +
                "                        \"status\": \"OK\",\n" +
                "                        \"fail_counter\": 0,\n" +
                "                        \"restart_counter\": 0,\n" +
                "                        \"last_restart\": 1510690321,\n" +
                "                        \"user_id\": 1,\n" +
                "                        \"exchange_id\": 1,\n" +
                "                        \"created_at\": \"2017-05-28 13:21:29\",\n" +
                "                        \"updated_at\": \"2017-09-14 12:28:01\",\n" +
                "                        \"deleted_on\": null\n" +
                "                    }\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 318,\n" +
                "                \"user_id\": 1,\n" +
                "                \"robot_id\": 383,\n" +
                "                \"trigger\": \"false_true\",\n" +
                "                \"action_table\": \"robot_action_trade\",\n" +
                "                \"action_id\": 16,\n" +
                "                \"status\": \"active\",\n" +
                "                \"backoff\": 0,\n" +
                "                \"created_at\": \"2017-11-20 08:48:07\",\n" +
                "                \"updated_at\": \"2017-11-20 08:48:07\",\n" +
                "                \"actionable\": {\n" +
                "                    \"id\": 16,\n" +
                "                    \"user_id\": 1,\n" +
                "                    \"robot_id\": 383,\n" +
                "                    \"account_id\": 39,\n" +
                "                    \"exchange_id\": 1,\n" +
                "                    \"side\": \"buy\",\n" +
                "                    \"quantity\": 1,\n" +
                "                    \"pair\": \"BCH_USD\",\n" +
                "                    \"created_at\": \"2017-11-20 08:48:07\",\n" +
                "                    \"updated_at\": \"2017-11-20 08:48:07\",\n" +
                "                    \"account\": {\n" +
                "                        \"id\": 39,\n" +
                "                        \"account_label\": \"Kraken\",\n" +
                "                        \"last_four\": \"dJnV\",\n" +
                "                        \"pwd\": \"Gp7CiIm6qLhdU4pira8cwozrLefQ\",\n" +
                "                        \"encryption_level\": \"2\",\n" +
                "                        \"creds\": \"iNrwMIAjTYnoTfLpQsfLHRgVd7y7we8wyrNg6JRrqIX8dbwPmaUeGjbPWgXqZs1w1N581o5Rt/7FvOb0HOx87ulXNDc22M59dM2zVWZcmvHwqUCAOQ3n06/sBVawJo1AZBwR3L6oCg7AYNwobREhQsq6ZjjLIUhIWQygH2KJu3LwFxVMfpLMT7WclU1gYemX6SCR2zkkdTxrGON0nW1zT0oV07EJQmux0KlL3owjuSWS+9nudNoDzfcZh6spMw==\",\n" +
                "                        \"creds_backup\": \"iNrwMIAjTYnoTfLpQsfLHRgVd7y7we8wyrNg6JRrqIX8dbwPmaUeGjbPWgXqZs1w1N581o5Rt/7FvOb0HOx87ulXNDc22M59dM2zVWZcmvHwqUCAOQ3n06/sBVawJo1AZBwR3L6oCg7AYNwobREhQsq6ZjjLIUhIWQygH2KJu3LwFxVMfpLMT7WclU1gYemX6SCR2zkkdTxrGON0nW1zT0oV07EJQmux0KlL3owjuSWS+9nudNoDzfcZh6spMw==\",\n" +
                "                        \"creds_hash\": \"a8798a3e0bb58ae0f260d02450144e5a17df85cfcbadb6bbb136d42fdc07237b\",\n" +
                "                        \"status\": \"OK\",\n" +
                "                        \"fail_counter\": 0,\n" +
                "                        \"restart_counter\": 0,\n" +
                "                        \"last_restart\": 1510690321,\n" +
                "                        \"user_id\": 1,\n" +
                "                        \"exchange_id\": 1,\n" +
                "                        \"created_at\": \"2017-05-28 13:21:29\",\n" +
                "                        \"updated_at\": \"2017-09-14 12:28:01\",\n" +
                "                        \"deleted_on\": null\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "        ],\n" +
                "        \"description\": \"Price to sell 0.5 BCH on Kraken is more than 1100 USD\",\n" +
                "        \"buttons\": \"<a href='' onclick=\\\"return changeState(383);\\\"><i class='fa fa-play' title='Restart'></i></a>&nbsp;&nbsp;<a href='' onclick=\\\"return flipDelete(383);\\\"><i class='fa fa-trash-o' title='Delete'></i></a>&nbsp;&nbsp;\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 382,\n" +
                "        \"robot_type\": \"Price Level\",\n" +
                "        \"game_only\": 0,\n" +
                "        \"name\": \"test real\",\n" +
                "        \"friendly\": null,\n" +
                "        \"params\": \"{\\\"side\\\":\\\"buy\\\",\\\"qty\\\":\\\"1\\\",\\\"pairA\\\":\\\"BCH\\\",\\\"pairB\\\":\\\"USD\\\",\\\"pair\\\":\\\"BCH_USD\\\",\\\"exchange\\\":\\\"1\\\",\\\"position\\\":\\\"above\\\",\\\"price\\\":\\\"1010\\\"}\",\n" +
                "        \"current_status\": \"paused\",\n" +
                "        \"current_state\": \"off\",\n" +
                "        \"action_trigger\": null,\n" +
                "        \"trigger_counter\": null,\n" +
                "        \"action_alert\": null,\n" +
                "        \"last_state_change\": \"2017-11-17 02:57:02\",\n" +
                "        \"last_action_executed\": null,\n" +
                "        \"uniqid\": null,\n" +
                "        \"deleted_on\": null,\n" +
                "        \"last_state_known\": \"true\",\n" +
                "        \"last_robot_evaluation\": \"2017-11-17 02:57:16\",\n" +
                "        \"last_state_change_group\": \"5a0e4ff952d837.87004954\",\n" +
                "        \"pushover_sound\": null,\n" +
                "        \"action_email\": null,\n" +
                "        \"action_notification_backoff\": null,\n" +
                "        \"action_activate\": null,\n" +
                "        \"action_trade\": null,\n" +
                "        \"action_trade_backoff\": null,\n" +
                "        \"user_id\": 1,\n" +
                "        \"created_at\": \"2017-11-16 18:45:57\",\n" +
                "        \"updated_at\": \"2017-11-17 10:57:17\",\n" +
                "        \"last_state_change_data\": \"{\\\"value_type\\\":\\\"price\\\",\\\"value\\\":\\\"1011.07700\\\",\\\"new_state\\\":\\\"true\\\"}\",\n" +
                "        \"robot_team\": null,\n" +
                "        \"robot_actions\": [\n" +
                "            {\n" +
                "                \"id\": 307,\n" +
                "                \"user_id\": 1,\n" +
                "                \"robot_id\": 382,\n" +
                "                \"trigger\": \"state_change\",\n" +
                "                \"action_table\": \"robot_action_pushover\",\n" +
                "                \"action_id\": 212,\n" +
                "                \"status\": \"active\",\n" +
                "                \"backoff\": 5,\n" +
                "                \"created_at\": \"2017-11-16 18:45:57\",\n" +
                "                \"updated_at\": \"2017-11-16 18:45:57\",\n" +
                "                \"actionable\": {\n" +
                "                    \"id\": 212,\n" +
                "                    \"user_id\": 1,\n" +
                "                    \"robot_id\": 382,\n" +
                "                    \"linked_email_robot_action_id\": null,\n" +
                "                    \"priority\": 1,\n" +
                "                    \"sound\": \"climb\",\n" +
                "                    \"backoff_seconds\": 3600,\n" +
                "                    \"msg_stub\": \"notification.robot_status_change_msg_pushover\",\n" +
                "                    \"created_at\": \"2017-11-16 18:45:57\",\n" +
                "                    \"updated_at\": \"2017-11-16 18:45:57\"\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": 309,\n" +
                "                \"user_id\": 1,\n" +
                "                \"robot_id\": 382,\n" +
                "                \"trigger\": \"false_true\",\n" +
                "                \"action_table\": \"robot_action_trade\",\n" +
                "                \"action_id\": 14,\n" +
                "                \"status\": \"active\",\n" +
                "                \"backoff\": 0,\n" +
                "                \"created_at\": \"2017-11-16 19:17:18\",\n" +
                "                \"updated_at\": \"2017-11-16 19:17:18\",\n" +
                "                \"actionable\": {\n" +
                "                    \"id\": 14,\n" +
                "                    \"user_id\": 1,\n" +
                "                    \"robot_id\": 382,\n" +
                "                    \"account_id\": 39,\n" +
                "                    \"exchange_id\": 1,\n" +
                "                    \"side\": \"buy\",\n" +
                "                    \"quantity\": 0.5,\n" +
                "                    \"pair\": \"BCH_EUR\",\n" +
                "                    \"created_at\": \"2017-11-16 19:17:18\",\n" +
                "                    \"updated_at\": \"2017-11-16 19:17:19\",\n" +
                "                    \"account\": {\n" +
                "                        \"id\": 39,\n" +
                "                        \"account_label\": \"Kraken\",\n" +
                "                        \"last_four\": \"dJnV\",\n" +
                "                        \"pwd\": \"Gp7CiIm6qLhdU4pira8cwozrLefQ\",\n" +
                "                        \"encryption_level\": \"2\",\n" +
                "                        \"creds\": \"iNrwMIAjTYnoTfLpQsfLHRgVd7y7we8wyrNg6JRrqIX8dbwPmaUeGjbPWgXqZs1w1N581o5Rt/7FvOb0HOx87ulXNDc22M59dM2zVWZcmvHwqUCAOQ3n06/sBVawJo1AZBwR3L6oCg7AYNwobREhQsq6ZjjLIUhIWQygH2KJu3LwFxVMfpLMT7WclU1gYemX6SCR2zkkdTxrGON0nW1zT0oV07EJQmux0KlL3owjuSWS+9nudNoDzfcZh6spMw==\",\n" +
                "                        \"creds_backup\": \"iNrwMIAjTYnoTfLpQsfLHRgVd7y7we8wyrNg6JRrqIX8dbwPmaUeGjbPWgXqZs1w1N581o5Rt/7FvOb0HOx87ulXNDc22M59dM2zVWZcmvHwqUCAOQ3n06/sBVawJo1AZBwR3L6oCg7AYNwobREhQsq6ZjjLIUhIWQygH2KJu3LwFxVMfpLMT7WclU1gYemX6SCR2zkkdTxrGON0nW1zT0oV07EJQmux0KlL3owjuSWS+9nudNoDzfcZh6spMw==\",\n" +
                "                        \"creds_hash\": \"a8798a3e0bb58ae0f260d02450144e5a17df85cfcbadb6bbb136d42fdc07237b\",\n" +
                "                        \"status\": \"OK\",\n" +
                "                        \"fail_counter\": 0,\n" +
                "                        \"restart_counter\": 0,\n" +
                "                        \"last_restart\": 1510690321,\n" +
                "                        \"user_id\": 1,\n" +
                "                        \"exchange_id\": 1,\n" +
                "                        \"created_at\": \"2017-05-28 13:21:29\",\n" +
                "                        \"updated_at\": \"2017-09-14 12:28:01\",\n" +
                "                        \"deleted_on\": null\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "        ],\n" +
                "        \"description\": \"Price to buy 1 BCH on Kraken is more than 1010 USD\",\n" +
                "        \"buttons\": \"<a href='' onclick=\\\"return changeState(382);\\\"><i class='fa fa-play' title='Restart'></i></a>&nbsp;&nbsp;<a href='' onclick=\\\"return flipDelete(382);\\\"><i class='fa fa-trash-o' title='Delete'></i></a>&nbsp;&nbsp;\"\n" +
                "    }\n" +
                "]";
    }
}
