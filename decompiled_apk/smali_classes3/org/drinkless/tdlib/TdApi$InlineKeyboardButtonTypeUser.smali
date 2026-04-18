.class public Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonTypeUser;
.super Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InlineKeyboardButtonTypeUser"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6d77e5a2


# instance fields
.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 14352
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonType;-><init>()V

    .line 14353
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 14343
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonType;-><init>()V

    .line 14344
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$InlineKeyboardButtonTypeUser;->userId:J

    .line 14345
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 14349
    const v0, 0x6d77e5a2

    return v0
.end method
