.class public Lorg/drinkless/tdlib/TdApi$ChatEvents;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatEvents"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x22e36c00


# instance fields
.field public events:[Lorg/drinkless/tdlib/TdApi$ChatEvent;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 10140
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 10141
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$ChatEvent;)V
    .locals 0
    .param p1, "chatEventArr"    # [Lorg/drinkless/tdlib/TdApi$ChatEvent;

    .line 10131
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 10132
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatEvents;->events:[Lorg/drinkless/tdlib/TdApi$ChatEvent;

    .line 10133
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 10137
    const v0, -0x22e36c00

    return v0
.end method
