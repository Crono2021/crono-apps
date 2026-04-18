.class public Lorg/drinkless/tdlib/TdApi$ToggleBotUsernameIsActive;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ToggleBotUsernameIsActive"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x79639409


# instance fields
.field public botUserId:J

.field public isActive:Z

.field public username:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 41076
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 41077
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;Z)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "z8"    # Z

    .line 41065
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 41066
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ToggleBotUsernameIsActive;->botUserId:J

    .line 41067
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$ToggleBotUsernameIsActive;->username:Ljava/lang/String;

    .line 41068
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$ToggleBotUsernameIsActive;->isActive:Z

    .line 41069
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 41073
    const v0, 0x79639409

    return v0
.end method
