#include <iostream>
#include <vector>
using namespace std;

// Implement class FunctionalList
template <typename T> class FunctionalList {
private:
  vector<T> elements;

public:
  // Add an element to the list
  void add(const T &element) { elements.push_back(element); }

  // Get the first element (head) of the list
  T head() const {
    if (elements.empty()) {
      throw runtime_error("List is empty. Cannot retrieve head.");
    }
    return elements.front();
  }

  // Get all elements except the first (tail) of the list
  vector<T> tail() const {
    if (elements.empty()) {
      throw runtime_error("List is empty. Cannot retrieve tail.");
    }
    return vector<T>(elements.begin() + 1, elements.end());
  }

  // Get all elements except the last (init) of the list
  vector<T> init() const {
    if (elements.empty()) {
      throw runtime_error("List is empty. Cannot retrieve init.");
    }
    return vector<T>(elements.begin(), elements.end() - 1);
  }

  // Get the last element of the list
  T last() const {
    if (elements.empty()) {
      throw runtime_error("List is empty. Cannot retrieve last.");
    }
    return elements.back();
  }
};

// Please keep the following test cases
int main() {
  FunctionalList<int> intList;
  intList.add(1);
  intList.add(2);
  intList.add(3);

  cout << "Integer List:\n";
  cout << "Head: " << intList.head() << endl;
  cout << "Tail: [ ";
  for (auto element : intList.tail()) {
    cout << element << " ";
  }
  cout << "]" << endl;
  cout << "Init: [ ";
  for (auto element : intList.init()) {
    cout << element << " ";
  }
  cout << "]" << endl;
  cout << "Last: " << intList.last() << endl;

  FunctionalList<string> stringList;
  stringList.add("apple");
  stringList.add("banana");
  stringList.add("orange");

  cout << "\nString List:\n";
  cout << "Head: " << stringList.head() << endl;
  cout << "Tail: [ ";
  for (auto element : stringList.tail()) {
    cout << element << " ";
  }
  cout << "]" << endl;
  cout << "Init: [ ";
  for (auto element : stringList.init()) {
    cout << element << " ";
  }
  cout << "]" << endl;
  cout << "Last: " << stringList.last() << endl;

  return 0;
}

/*
Integer List:
Head: 1
Tail: [ 2 3 ]
Init: [ 1 2 ]
Last: 3

String List:
Head: apple
Tail: [ banana orange ]
Init: [ apple banana ]
Last: orange
*/
