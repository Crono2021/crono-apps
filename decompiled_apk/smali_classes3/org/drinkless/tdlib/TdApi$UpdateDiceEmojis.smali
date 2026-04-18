.class public Lorg/drinkless/tdlib/TdApi$UpdateDiceEmojis;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateDiceEmojis"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3fb8aabc


# instance fields
.field public emojis:[Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 21710
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21711
    return-void
.end method

.method public constructor <init>([Ljava/lang/String;)V
    .locals 0
    .param p1, "strArr"    # [Ljava/lang/String;

    .line 21701
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21702
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateDiceEmojis;->emojis:[Ljava/lang/String;

    .line 21703
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 21707
    const v0, -0x3fb8aabc

    return v0
.end method
