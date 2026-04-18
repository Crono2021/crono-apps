.class public Lorg/drinkless/tdlib/TdApi$UpdatePoll;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdatePoll"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x69948c36


# instance fields
.field public poll:Lorg/drinkless/tdlib/TdApi$Poll;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 21944
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21945
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Poll;)V
    .locals 0
    .param p1, "poll"    # Lorg/drinkless/tdlib/TdApi$Poll;

    .line 21935
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21936
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdatePoll;->poll:Lorg/drinkless/tdlib/TdApi$Poll;

    .line 21937
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 21941
    const v0, -0x69948c36

    return v0
.end method
