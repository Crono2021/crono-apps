.class public Lorg/drinkless/tdlib/TdApi$ChatLocation;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatLocation"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5d6470df


# instance fields
.field public address:Ljava/lang/String;

.field public location:Lorg/drinkless/tdlib/TdApi$Location;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 24264
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 24265
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Location;Ljava/lang/String;)V
    .locals 0
    .param p1, "location"    # Lorg/drinkless/tdlib/TdApi$Location;
    .param p2, "str"    # Ljava/lang/String;

    .line 24254
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 24255
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatLocation;->location:Lorg/drinkless/tdlib/TdApi$Location;

    .line 24256
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ChatLocation;->address:Ljava/lang/String;

    .line 24257
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 24261
    const v0, -0x5d6470df

    return v0
.end method
