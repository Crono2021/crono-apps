.class public Lorg/drinkless/tdlib/TdApi$CurrentWeather;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CurrentWeather"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x15315740


# instance fields
.field public emoji:Ljava/lang/String;

.field public temperature:D


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 24784
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 24785
    return-void
.end method

.method public constructor <init>(DLjava/lang/String;)V
    .locals 0
    .param p1, "d9"    # D
    .param p3, "str"    # Ljava/lang/String;

    .line 24774
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 24775
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$CurrentWeather;->temperature:D

    .line 24776
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$CurrentWeather;->emoji:Ljava/lang/String;

    .line 24777
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 24781
    const v0, -0x15315740

    return v0
.end method
