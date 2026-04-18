.class public Lorg/drinkless/tdlib/TdApi$SetChatPermissions;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetChatPermissions"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7f7706fe


# instance fields
.field public chatId:J

.field public permissions:Lorg/drinkless/tdlib/TdApi$ChatPermissions;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 31368
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31369
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$ChatPermissions;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "chatPermissions"    # Lorg/drinkless/tdlib/TdApi$ChatPermissions;

    .line 31358
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31359
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SetChatPermissions;->chatId:J

    .line 31360
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SetChatPermissions;->permissions:Lorg/drinkless/tdlib/TdApi$ChatPermissions;

    .line 31361
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 31365
    const v0, 0x7f7706fe

    return v0
.end method
