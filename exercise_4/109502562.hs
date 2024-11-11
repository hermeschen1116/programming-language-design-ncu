-- Practice A
isPalindrome :: Eq a => [a] -> Bool
isPalindrome xs = checkPalindrome xs 0 (length xs - 1)
    where
        checkPalindrome xs left right
                        | left >= right = True                      
                        | xs !! left /= xs !! right = False        
                        | otherwise = checkPalindrome xs (left + 1) (right - 1)  


testcasesA :: [[Int]]
testcasesA = [[], [5..15], [1,1,1,0], [7,3,7]]

resultA :: [Bool]
resultA = map isPalindrome testcasesA 



-- Practice B
coolDiv :: [Double] -> Either String Double
coolDiv (0:_) = Left "Division by zero"
coolDiv (d0:d1:_) = Right (d1 / d0)
coolDiv null = Left "Too short"

testcasesB :: [[Double]]
testcasesB = [[], [5..15], [999], [33,9999], [0..9]]

resultB :: [Either String Double]
resultB = map coolDiv testcasesB



main :: IO ()
main = do
  print resultA -- [True,False,False,True]
  print resultB -- [Left "Too short",Right 1.2,Left "Too short",Right 303.0,Left "Division by zero"]