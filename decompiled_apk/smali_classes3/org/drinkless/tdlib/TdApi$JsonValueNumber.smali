.class public Lorg/drinkless/tdlib/TdApi$JsonValueNumber;
.super Lorg/drinkless/tdlib/TdApi$JsonValue;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "JsonValueNumber"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3c3feb91


# instance fields
.field public value:D


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 15630
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$JsonValue;-><init>()V

    .line 15631
    return-void
.end method

.method public constructor <init>(D)V
    .locals 0
    .param p1, "d9"    # D

    .line 15621
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$JsonValue;-><init>()V

    .line 15622
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$JsonValueNumber;->value:D

    .line 15623
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 15627
    const v0, -0x3c3feb91

    return v0
.end method
