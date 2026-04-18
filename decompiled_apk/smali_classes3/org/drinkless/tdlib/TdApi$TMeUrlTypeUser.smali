.class public Lorg/drinkless/tdlib/TdApi$TMeUrlTypeUser;
.super Lorg/drinkless/tdlib/TdApi$TMeUrlType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TMeUrlTypeUser"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7787c1a


# instance fields
.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 20796
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$TMeUrlType;-><init>()V

    .line 20797
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 20787
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$TMeUrlType;-><init>()V

    .line 20788
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$TMeUrlTypeUser;->userId:J

    .line 20789
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 20793
    const v0, 0x7787c1a

    return v0
.end method
