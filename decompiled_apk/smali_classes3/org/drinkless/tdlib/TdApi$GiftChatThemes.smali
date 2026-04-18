.class public Lorg/drinkless/tdlib/TdApi$GiftChatThemes;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GiftChatThemes"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x79297ddb


# instance fields
.field public nextOffset:Ljava/lang/String;

.field public themes:[Lorg/drinkless/tdlib/TdApi$GiftChatTheme;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 26884
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 26885
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$GiftChatTheme;Ljava/lang/String;)V
    .locals 0
    .param p1, "giftChatThemeArr"    # [Lorg/drinkless/tdlib/TdApi$GiftChatTheme;
    .param p2, "str"    # Ljava/lang/String;

    .line 26874
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 26875
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GiftChatThemes;->themes:[Lorg/drinkless/tdlib/TdApi$GiftChatTheme;

    .line 26876
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$GiftChatThemes;->nextOffset:Ljava/lang/String;

    .line 26877
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 26881
    const v0, 0x79297ddb

    return v0
.end method
