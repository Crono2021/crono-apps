.class public Lorg/drinkless/tdlib/TdApi$GetCurrentWeather;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetCurrentWeather"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$CurrentWeather;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x75256437


# instance fields
.field public location:Lorg/drinkless/tdlib/TdApi$Location;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 12696
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12697
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Location;)V
    .locals 0
    .param p1, "location"    # Lorg/drinkless/tdlib/TdApi$Location;

    .line 12687
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12688
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetCurrentWeather;->location:Lorg/drinkless/tdlib/TdApi$Location;

    .line 12689
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 12693
    const v0, -0x75256437

    return v0
.end method
