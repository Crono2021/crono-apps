.class public Lorg/drinkless/tdlib/TdApi$InternalLinkTypeBotAddToChannel;
.super Lorg/drinkless/tdlib/TdApi$InternalLinkType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InternalLinkTypeBotAddToChannel"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x538ac2c0


# instance fields
.field public administratorRights:Lorg/drinkless/tdlib/TdApi$ChatAdministratorRights;

.field public botUsername:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 27604
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 27605
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$ChatAdministratorRights;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "chatAdministratorRights"    # Lorg/drinkless/tdlib/TdApi$ChatAdministratorRights;

    .line 27594
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 27595
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeBotAddToChannel;->botUsername:Ljava/lang/String;

    .line 27596
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeBotAddToChannel;->administratorRights:Lorg/drinkless/tdlib/TdApi$ChatAdministratorRights;

    .line 27597
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 27601
    const v0, 0x538ac2c0

    return v0
.end method
