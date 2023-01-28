/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * Generated with the TypeScript template
 * https://github.com/react-native-community/react-native-template-typescript
 *
 * @format
 */

import React, {useState, type PropsWithChildren} from 'react';
import {
  Button,
  SafeAreaView,
  ScrollView,
  StatusBar,
  StyleSheet,
  Text,
  useColorScheme,
  View,
} from 'react-native';

import {NativeModules} from 'react-native';
const {CalendarModule} = NativeModules;

const App = () => {
  const [st1, SetSt1] = useState(0);

  return (
    <View>
      <SafeAreaView style={{backgroundColor: 'red'}} />
      <Text style={[styles.centerTxt]}>Sina Kordestani</Text>
      <Button
        title="Start"
        onPress={() => {
          CalendarModule.createCalendarEvent('testName', 'dgdf');
        }}></Button>

      <Button
        title="Stop"
        onPress={() => {
          CalendarModule.stopEvent('testName');
        }}></Button>

      <Button
        title="Change"
        onPress={() => {
          CalendarModule.changeEvent(st1);
          const x = st1 + 1;
          SetSt1(x);
        }}
      />
    </View>
  );
};

const styles = StyleSheet.create({
  centerTxt: {
    textAlign: 'center',
  },
});

export default App;
