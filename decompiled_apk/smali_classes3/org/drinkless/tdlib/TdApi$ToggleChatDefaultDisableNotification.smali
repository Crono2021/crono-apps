.class public Lorg/drinkless/tdlib/TdApi$ToggleChatDefaultDisableNotification;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ToggleChatDefaultDisableNotification"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x12c36012


# instance fields
.field public chatId:J

.field public defaultDisableNotification:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 33068
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33069
    return-void
.end method

.method public constructor <init>(JZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "z8"    # Z

    .line 33058
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33059
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ToggleChatDefaultDisableNotification;->chatId:J

    .line 33060
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$ToggleChatDefaultDisableNotification;->defaultDisableNotification:Z

    .line 33061
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 33065
    const v0, 0x12c36012

    return v0
.end method
