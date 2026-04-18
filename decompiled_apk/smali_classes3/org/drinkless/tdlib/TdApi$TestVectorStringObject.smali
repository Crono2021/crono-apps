.class public Lorg/drinkless/tdlib/TdApi$TestVectorStringObject;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TestVectorStringObject"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4d09cf9


# instance fields
.field public value:[Lorg/drinkless/tdlib/TdApi$TestString;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 21170
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 21171
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$TestString;)V
    .locals 0
    .param p1, "testStringArr"    # [Lorg/drinkless/tdlib/TdApi$TestString;

    .line 21161
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 21162
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$TestVectorStringObject;->value:[Lorg/drinkless/tdlib/TdApi$TestString;

    .line 21163
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 21167
    const v0, 0x4d09cf9

    return v0
.end method
