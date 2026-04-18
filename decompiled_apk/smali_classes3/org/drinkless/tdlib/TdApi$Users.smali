.class public Lorg/drinkless/tdlib/TdApi$Users;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Users"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0xa345b5c


# instance fields
.field public totalCount:I

.field public userIds:[J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 35248
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 35249
    return-void
.end method

.method public constructor <init>(I[J)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "jArr"    # [J

    .line 35238
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 35239
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$Users;->totalCount:I

    .line 35240
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$Users;->userIds:[J

    .line 35241
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 35245
    const v0, 0xa345b5c

    return v0
.end method
