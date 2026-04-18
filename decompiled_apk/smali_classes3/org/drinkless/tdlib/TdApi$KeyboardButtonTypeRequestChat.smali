.class public Lorg/drinkless/tdlib/TdApi$KeyboardButtonTypeRequestChat;
.super Lorg/drinkless/tdlib/TdApi$KeyboardButtonType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "KeyboardButtonTypeRequestChat"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x5a1224b5


# instance fields
.field public botAdministratorRights:Lorg/drinkless/tdlib/TdApi$ChatAdministratorRights;

.field public botIsMember:Z

.field public chatHasUsername:Z

.field public chatIsChannel:Z

.field public chatIsCreated:Z

.field public chatIsForum:Z

.field public id:I

.field public requestPhoto:Z

.field public requestTitle:Z

.field public requestUsername:Z

.field public restrictChatHasUsername:Z

.field public restrictChatIsForum:Z

.field public userAdministratorRights:Lorg/drinkless/tdlib/TdApi$ChatAdministratorRights;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 54036
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$KeyboardButtonType;-><init>()V

    .line 54037
    return-void
.end method

.method public constructor <init>(IZZZZZZLorg/drinkless/tdlib/TdApi$ChatAdministratorRights;Lorg/drinkless/tdlib/TdApi$ChatAdministratorRights;ZZZZ)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "z8"    # Z
    .param p3, "z9"    # Z
    .param p4, "z10"    # Z
    .param p5, "z11"    # Z
    .param p6, "z12"    # Z
    .param p7, "z13"    # Z
    .param p8, "chatAdministratorRights"    # Lorg/drinkless/tdlib/TdApi$ChatAdministratorRights;
    .param p9, "chatAdministratorRights2"    # Lorg/drinkless/tdlib/TdApi$ChatAdministratorRights;
    .param p10, "z14"    # Z
    .param p11, "z15"    # Z
    .param p12, "z16"    # Z
    .param p13, "z17"    # Z

    .line 54015
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$KeyboardButtonType;-><init>()V

    .line 54016
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$KeyboardButtonTypeRequestChat;->id:I

    .line 54017
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$KeyboardButtonTypeRequestChat;->chatIsChannel:Z

    .line 54018
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$KeyboardButtonTypeRequestChat;->restrictChatIsForum:Z

    .line 54019
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$KeyboardButtonTypeRequestChat;->chatIsForum:Z

    .line 54020
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$KeyboardButtonTypeRequestChat;->restrictChatHasUsername:Z

    .line 54021
    iput-boolean p6, p0, Lorg/drinkless/tdlib/TdApi$KeyboardButtonTypeRequestChat;->chatHasUsername:Z

    .line 54022
    iput-boolean p7, p0, Lorg/drinkless/tdlib/TdApi$KeyboardButtonTypeRequestChat;->chatIsCreated:Z

    .line 54023
    iput-object p8, p0, Lorg/drinkless/tdlib/TdApi$KeyboardButtonTypeRequestChat;->userAdministratorRights:Lorg/drinkless/tdlib/TdApi$ChatAdministratorRights;

    .line 54024
    iput-object p9, p0, Lorg/drinkless/tdlib/TdApi$KeyboardButtonTypeRequestChat;->botAdministratorRights:Lorg/drinkless/tdlib/TdApi$ChatAdministratorRights;

    .line 54025
    iput-boolean p10, p0, Lorg/drinkless/tdlib/TdApi$KeyboardButtonTypeRequestChat;->botIsMember:Z

    .line 54026
    iput-boolean p11, p0, Lorg/drinkless/tdlib/TdApi$KeyboardButtonTypeRequestChat;->requestTitle:Z

    .line 54027
    iput-boolean p12, p0, Lorg/drinkless/tdlib/TdApi$KeyboardButtonTypeRequestChat;->requestUsername:Z

    .line 54028
    iput-boolean p13, p0, Lorg/drinkless/tdlib/TdApi$KeyboardButtonTypeRequestChat;->requestPhoto:Z

    .line 54029
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 54033
    const v0, 0x5a1224b5

    return v0
.end method
