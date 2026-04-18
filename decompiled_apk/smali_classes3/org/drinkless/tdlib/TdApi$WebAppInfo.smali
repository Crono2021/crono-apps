.class public Lorg/drinkless/tdlib/TdApi$WebAppInfo;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "WebAppInfo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2efdb2e8


# instance fields
.field public launchId:J

.field public url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 35288
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 35289
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;

    .line 35278
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 35279
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$WebAppInfo;->launchId:J

    .line 35280
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$WebAppInfo;->url:Ljava/lang/String;

    .line 35281
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 35285
    const v0, 0x2efdb2e8

    return v0
.end method
