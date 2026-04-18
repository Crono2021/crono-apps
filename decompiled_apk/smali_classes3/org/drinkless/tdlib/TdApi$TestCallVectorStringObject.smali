.class public Lorg/drinkless/tdlib/TdApi$TestCallVectorStringObject;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TestCallVectorStringObject"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$TestVectorStringObject;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x5b0e56fd


# instance fields
.field public f8026x:[Lorg/drinkless/tdlib/TdApi$TestString;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 21024
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 21025
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$TestString;)V
    .locals 0
    .param p1, "testStringArr"    # [Lorg/drinkless/tdlib/TdApi$TestString;

    .line 21015
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 21016
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$TestCallVectorStringObject;->f8026x:[Lorg/drinkless/tdlib/TdApi$TestString;

    .line 21017
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 21021
    const v0, 0x5b0e56fd

    return v0
.end method
