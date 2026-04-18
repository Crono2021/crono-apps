.class public Lorg/drinkless/tdlib/TdApi$UpdateChatActiveStories;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateChatActiveStories"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x79786c2c


# instance fields
.field public activeStories:Lorg/drinkless/tdlib/TdApi$ChatActiveStories;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 21620
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21621
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ChatActiveStories;)V
    .locals 0
    .param p1, "chatActiveStories"    # Lorg/drinkless/tdlib/TdApi$ChatActiveStories;

    .line 21611
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21612
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatActiveStories;->activeStories:Lorg/drinkless/tdlib/TdApi$ChatActiveStories;

    .line 21613
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 21617
    const v0, 0x79786c2c

    return v0
.end method
