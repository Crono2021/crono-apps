.class public Lorg/drinkless/tdlib/TdApi$StoryAreaTypeLocation;
.super Lorg/drinkless/tdlib/TdApi$StoryAreaType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StoryAreaTypeLocation"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x574c355d


# instance fields
.field public address:Lorg/drinkless/tdlib/TdApi$LocationAddress;

.field public location:Lorg/drinkless/tdlib/TdApi$Location;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 32788
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StoryAreaType;-><init>()V

    .line 32789
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Location;Lorg/drinkless/tdlib/TdApi$LocationAddress;)V
    .locals 0
    .param p1, "location"    # Lorg/drinkless/tdlib/TdApi$Location;
    .param p2, "locationAddress"    # Lorg/drinkless/tdlib/TdApi$LocationAddress;

    .line 32778
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StoryAreaType;-><init>()V

    .line 32779
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$StoryAreaTypeLocation;->location:Lorg/drinkless/tdlib/TdApi$Location;

    .line 32780
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$StoryAreaTypeLocation;->address:Lorg/drinkless/tdlib/TdApi$LocationAddress;

    .line 32781
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 32785
    const v0, -0x574c355d

    return v0
.end method
