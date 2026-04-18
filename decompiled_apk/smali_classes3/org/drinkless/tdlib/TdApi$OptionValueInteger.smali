.class public Lorg/drinkless/tdlib/TdApi$OptionValueInteger;
.super Lorg/drinkless/tdlib/TdApi$OptionValue;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "OptionValueInteger"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0xb233d1c


# instance fields
.field public value:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 17088
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$OptionValue;-><init>()V

    .line 17089
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 17079
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$OptionValue;-><init>()V

    .line 17080
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$OptionValueInteger;->value:J

    .line 17081
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 17085
    const v0, -0xb233d1c

    return v0
.end method
