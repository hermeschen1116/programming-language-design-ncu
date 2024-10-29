from typing import List


class BasicFormatter:
    def format(self, message: str) -> str:
        return f"{message}!"


class FormatterDecorator(BasicFormatter):
    def __init__(self, Formatter: BasicFormatter):
        self._Formatter = Formatter

    def format(self, message: str) -> str:
        return self._Formatter.format(message)


class Observer:
    def __init__(self, name: str, Formatter: BasicFormatter):
        self.name: str = name
        self._Formatter = Formatter

    def update(self, message: str) -> None:
        print(f"{self.name} get the message: ", end="")
        print(self._Formatter.format(message))


# The above are fixed classes, please do not modify it.
# Please complete other classes here >>


class Messenger:
    def __init__(self) -> None:
        self.observers: list[Observer] = []

    def attach(self, observer: Observer) -> None:
        self.observers.append(observer)

    def send_message(self, message: str) -> None:
        if len(self.observers) != 0:
            for obs in self.observers:
                obs.update(message)


class ReverseDecorator(FormatterDecorator):
    def format(self, message: str) -> str:
        return self.reverse(super().format(message))

    def reverse(self, message: str) -> str:
        # Formatting: reversing the message
        return "".join(reversed(message))


class StarDecorator(FormatterDecorator):
    def format(self, message: str) -> str:
        return self.addStar(super().format(message))

    def addStar(self, message: str) -> str:
        # Formatting: adding * at the beginning and the end of the message
        return f"*{message}*"


# << Please complete other classes here
# The following are the test cases, please do not modify them

# messenger is the subject to be observed
messenger = Messenger()

"""
Create Formatters by using decorator pattern.
Then use the Formatters to create observers.
"""
observers: List[Observer] = [
    Observer("Alice", BasicFormatter()),
    Observer("Bob", ReverseDecorator(BasicFormatter())),
    Observer("Charlie", StarDecorator(BasicFormatter())),
    Observer("Dave", ReverseDecorator(StarDecorator(BasicFormatter()))),
]

# Add the subscribers (observers) to the messenger
for observer in observers:
    messenger.attach(observer)

# Send the message
messenger.send_message("Hello, observer")

"""
Output:
Alice get the message: Hello, observer!
Bob get the message: !revresbo ,olleH
Charlie get the message: *Hello, observer!*
Dave get the message: *!revresbo ,olleH*
"""
