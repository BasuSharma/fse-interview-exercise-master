import React from 'react';
import { screen } from '@testing-library/react';
import App from './App';
import Enzyme, { shallow, render, mount } from 'enzyme';
import toJson from 'enzyme-to-json';
import Adapter from '@wojtekmaj/enzyme-adapter-react-17';

Enzyme.configure({ adapter: new Adapter() })


it("renders correctly", () => {
  const tree = shallow(<App />);
  expect(toJson(tree)).toMatchSnapshot();
});
