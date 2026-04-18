.class public Lorg/drinkless/tdlib/TdApi$InputStoryAreaTypeLocation;
.super Lorg/drinkless/tdlib/TdApi$InputStoryAreaType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputStoryAreaTypeLocation"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5574c0c7


# instance fields
.field public address:Lorg/drinkless/tdlib/TdApi$LocationAddress;

.field public location:Lorg/drinkless/tdlib/TdApi$Location;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 27484
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputStoryAreaType;-><init>()V

    .line 27485
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Location;Lorg/drinkless/tdlib/TdApi$LocationAddress;)V
    .locals 0
    .param p1, "location"    # Lorg/drinkless/tdlib/TdApi$Location;
    .param p2, "locationAddress"    # Lorg/drinkless/tdlib/TdApi$LocationAddress;

    .line 27474
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputStoryAreaType;-><init>()V

    .line 27475
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputStoryAreaTypeLocation;->location:Lorg/drinkless/tdlib/TdApi$Location;

    .line 27476
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InputStoryAreaTypeLocation;->address:Lorg/drinkless/tdlib/TdApi$LocationAddress;

    .line 27477
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 27481
    const v0, -0x5574c0c7

    return v0
.end method
