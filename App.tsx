/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * Generated with the TypeScript template
 * https://github.com/react-native-community/react-native-template-typescript
 *
 * @format
 */

import React, {type PropsWithChildren} from 'react';
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
  return (
    <View>
      <SafeAreaView style={{backgroundColor: 'red'}} />
      <Text style={[styles.centerTxt]}>Sina Kordestani</Text>
      <Button
        title="Click"
        onPress={() => {
          CalendarModule.createCalendarEvent('testName', 'dgdf');
        }}></Button>

      <Button
        title="Click"
        onPress={() => {
          CalendarModule.stopEvent('testName');
        }}></Button>
    </View>
  );
};

const styles = StyleSheet.create({
  centerTxt: {
    textAlign: 'center',
  },
});

export default App;
