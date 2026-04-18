.class public Lorg/drinkless/tdlib/TdApi$InternalLinkTypeBotStartInGroup;
.super Lorg/drinkless/tdlib/TdApi$InternalLinkType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InternalLinkTypeBotStartInGroup"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x35f27332


# instance fields
.field public administratorRights:Lorg/drinkless/tdlib/TdApi$ChatAdministratorRights;

.field public botUsername:Ljava/lang/String;

.field public startParameter:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 38150
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 38151
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$ChatAdministratorRights;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "chatAdministratorRights"    # Lorg/drinkless/tdlib/TdApi$ChatAdministratorRights;

    .line 38139
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 38140
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeBotStartInGroup;->botUsername:Ljava/lang/String;

    .line 38141
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeBotStartInGroup;->startParameter:Ljava/lang/String;

    .line 38142
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeBotStartInGroup;->administratorRights:Lorg/drinkless/tdlib/TdApi$ChatAdministratorRights;

    .line 38143
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 38147
    const v0, -0x35f27332

    return v0
.end method
