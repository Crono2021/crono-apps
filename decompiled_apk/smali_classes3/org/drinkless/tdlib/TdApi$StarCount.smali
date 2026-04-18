.class public Lorg/drinkless/tdlib/TdApi$StarCount;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StarCount"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5d5d4b08


# instance fields
.field public starCount:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 20058
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 20059
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 20049
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 20050
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$StarCount;->starCount:J

    .line 20051
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 20055
    const v0, -0x5d5d4b08

    return v0
.end method
