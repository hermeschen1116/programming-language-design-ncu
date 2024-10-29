from typing import List


class Beverage:
    def cost(self) -> int:
        return 0

    def description(self) -> str:
        return "beverage"


class Decorator(Beverage):
    def __init__(self, beverage: Beverage) -> None:
        self.beverage = beverage

    def cost(self) -> int:
        return self.beverage.cost()

    def description(self) -> str:
        return self.beverage.description()


# The above is a fixed class, please do not modify it.
# Please complete other classes here >>


class BlackTea(Beverage):
    def cost(self) -> int:
        return 25

    def description(self) -> str:
        return "blackTea"


class GreenTea(Beverage):
    def cost(self) -> int:
        return 20

    def description(self) -> str:
        return "greenTea"


class Ice(Decorator):
    def cost(self) -> int:
        return self.beverage.cost() + 1

    def description(self) -> str:
        return f"{self.beverage.description()} + ice"


class Milk(Decorator):
    def cost(self) -> int:
        return self.beverage.cost() + 5

    def description(self) -> str:
        return f"{self.beverage.description()} + milk"


class Bubble(Decorator):
    def cost(self) -> int:
        return self.beverage.cost() + 10

    def description(self) -> str:
        return f"{self.beverage.description()} + bubble"


# << Please complete other classes here
# The following are the test cases, please do not modify them

beverages: List[Beverage] = [GreenTea(), Milk(Milk(BlackTea())), Milk(Ice(GreenTea())), Bubble(Milk(Ice(BlackTea())))]

for b in beverages:
    if isinstance(b, Beverage):
        print(f"{b.description()} is a beverage!")
    else:
        print(f"{b.description()} is not a beverage?")
    print(f"Its price is {b.cost()}")

"""
Output:
greenTea is a beverage!
Its price is 20
blackTea + milk + milk is a beverage!
Its price is 35
greenTea + ice + milk is a beverage!
Its price is 26
blackTea + ice + milk + bubble is a beverage!
Its price is 41
"""
