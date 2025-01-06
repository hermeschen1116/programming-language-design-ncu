#include <iostream>
#include <string>
#include <typeinfo>

using namespace std;

class Shape {
public:
  virtual void draw() const {}
};
class Circle : public Shape {
public:
  void draw() const { cout << "Drawing a Circle" << endl; }
};
class Rectangle : public Shape {
public:
  void draw() const { cout << "Drawing a Rectangle" << std::endl; }
};

// Define a function identifyAndDraw to identify the type of the object, and
// then calls the draw method
void identifyAndDraw(Shape *shape) {
  if (dynamic_cast<Circle *>(shape)) {
    cout << "This is a Circle" << endl;
    shape->draw();
  } else if (dynamic_cast<Rectangle *>(shape)) {
    cout << "This is a Rectangle" << endl;
    shape->draw();
  } else {
    cout << "Unknown Shape" << endl;
    shape->draw();
  }
}

int main() {
  Shape *shape1 = new Circle;
  Shape *shape2 = new Rectangle;
  Shape *shape3 = new Shape;
  identifyAndDraw(shape1);
  identifyAndDraw(shape2);
  identifyAndDraw(shape3);
  delete shape1;
  delete shape2;
  delete shape3;
  return 0;
}

/*
This is a Circle
Drawing a Circle
This is a Rectangle
Drawing a Rectangle
Unknown Shape
*/
