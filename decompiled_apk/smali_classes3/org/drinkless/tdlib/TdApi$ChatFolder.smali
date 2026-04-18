.class public Lorg/drinkless/tdlib/TdApi$ChatFolder;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatFolder"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x5f238a58


# instance fields
.field public colorId:I

.field public excludeArchived:Z

.field public excludeMuted:Z

.field public excludeRead:Z

.field public excludedChatIds:[J

.field public icon:Lorg/drinkless/tdlib/TdApi$ChatFolderIcon;

.field public includeBots:Z

.field public includeChannels:Z

.field public includeContacts:Z

.field public includeGroups:Z

.field public includeNonContacts:Z

.field public includedChatIds:[J

.field public isShareable:Z

.field public name:Lorg/drinkless/tdlib/TdApi$ChatFolderName;

.field public pinnedChatIds:[J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 54518
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 54519
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ChatFolderName;Lorg/drinkless/tdlib/TdApi$ChatFolderIcon;IZ[J[J[JZZZZZZZZ)V
    .locals 0
    .param p1, "chatFolderName"    # Lorg/drinkless/tdlib/TdApi$ChatFolderName;
    .param p2, "chatFolderIcon"    # Lorg/drinkless/tdlib/TdApi$ChatFolderIcon;
    .param p3, "i9"    # I
    .param p4, "z8"    # Z
    .param p5, "jArr"    # [J
    .param p6, "jArr2"    # [J
    .param p7, "jArr3"    # [J
    .param p8, "z9"    # Z
    .param p9, "z10"    # Z
    .param p10, "z11"    # Z
    .param p11, "z12"    # Z
    .param p12, "z13"    # Z
    .param p13, "z14"    # Z
    .param p14, "z15"    # Z
    .param p15, "z16"    # Z

    .line 54495
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 54496
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatFolder;->name:Lorg/drinkless/tdlib/TdApi$ChatFolderName;

    .line 54497
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ChatFolder;->icon:Lorg/drinkless/tdlib/TdApi$ChatFolderIcon;

    .line 54498
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$ChatFolder;->colorId:I

    .line 54499
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$ChatFolder;->isShareable:Z

    .line 54500
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$ChatFolder;->pinnedChatIds:[J

    .line 54501
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$ChatFolder;->includedChatIds:[J

    .line 54502
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$ChatFolder;->excludedChatIds:[J

    .line 54503
    iput-boolean p8, p0, Lorg/drinkless/tdlib/TdApi$ChatFolder;->excludeMuted:Z

    .line 54504
    iput-boolean p9, p0, Lorg/drinkless/tdlib/TdApi$ChatFolder;->excludeRead:Z

    .line 54505
    iput-boolean p10, p0, Lorg/drinkless/tdlib/TdApi$ChatFolder;->excludeArchived:Z

    .line 54506
    iput-boolean p11, p0, Lorg/drinkless/tdlib/TdApi$ChatFolder;->includeContacts:Z

    .line 54507
    iput-boolean p12, p0, Lorg/drinkless/tdlib/TdApi$ChatFolder;->includeNonContacts:Z

    .line 54508
    iput-boolean p13, p0, Lorg/drinkless/tdlib/TdApi$ChatFolder;->includeBots:Z

    .line 54509
    iput-boolean p14, p0, Lorg/drinkless/tdlib/TdApi$ChatFolder;->includeGroups:Z

    .line 54510
    iput-boolean p15, p0, Lorg/drinkless/tdlib/TdApi$ChatFolder;->includeChannels:Z

    .line 54511
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 54515
    const v0, 0x5f238a58

    return v0
.end method
