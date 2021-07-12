import React from 'react';
import { screen } from '@testing-library/react';
import Enzyme, { shallow, render, mount } from 'enzyme';
import toJson from 'enzyme-to-json';
import Adapter from '@wojtekmaj/enzyme-adapter-react-17';
import ErrorPage from './ErrorPage';

Enzyme.configure({ adapter: new Adapter() })


it("renders correctly", () => {
  const tree = shallow(<ErrorPage />);
  expect(toJson(tree)).toMatchSnapshot();
});
