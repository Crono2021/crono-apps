.class public Lorg/drinkless/tdlib/TdApi$GetBasicGroupFullInfo;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetBasicGroupFullInfo"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$BasicGroupFullInfo;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6c9a1cd5


# instance fields
.field public basicGroupId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 12102
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12103
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 12093
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12094
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetBasicGroupFullInfo;->basicGroupId:J

    .line 12095
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 12099
    const v0, -0x6c9a1cd5

    return v0
.end method
