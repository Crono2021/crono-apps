.class public Lorg/drinkless/tdlib/TdApi$ChatMemberStatusAdministrator;
.super Lorg/drinkless/tdlib/TdApi$ChatMemberStatus;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatMemberStatusAdministrator"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x42c7be3


# instance fields
.field public canBeEdited:Z

.field public customTitle:Ljava/lang/String;

.field public rights:Lorg/drinkless/tdlib/TdApi$ChatAdministratorRights;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 36212
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatMemberStatus;-><init>()V

    .line 36213
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;ZLorg/drinkless/tdlib/TdApi$ChatAdministratorRights;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "z8"    # Z
    .param p3, "chatAdministratorRights"    # Lorg/drinkless/tdlib/TdApi$ChatAdministratorRights;

    .line 36201
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatMemberStatus;-><init>()V

    .line 36202
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatMemberStatusAdministrator;->customTitle:Ljava/lang/String;

    .line 36203
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$ChatMemberStatusAdministrator;->canBeEdited:Z

    .line 36204
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$ChatMemberStatusAdministrator;->rights:Lorg/drinkless/tdlib/TdApi$ChatAdministratorRights;

    .line 36205
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 36209
    const v0, -0x42c7be3

    return v0
.end method
