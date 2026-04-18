.class public Lorg/drinkless/tdlib/TdApi$ChatFolderInfo;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatFolderInfo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x309c140d


# instance fields
.field public colorId:I

.field public hasMyInviteLinks:Z

.field public icon:Lorg/drinkless/tdlib/TdApi$ChatFolderIcon;

.field public id:I

.field public isShareable:Z

.field public name:Lorg/drinkless/tdlib/TdApi$ChatFolderName;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 49506
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 49507
    return-void
.end method

.method public constructor <init>(ILorg/drinkless/tdlib/TdApi$ChatFolderName;Lorg/drinkless/tdlib/TdApi$ChatFolderIcon;IZZ)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "chatFolderName"    # Lorg/drinkless/tdlib/TdApi$ChatFolderName;
    .param p3, "chatFolderIcon"    # Lorg/drinkless/tdlib/TdApi$ChatFolderIcon;
    .param p4, "i10"    # I
    .param p5, "z8"    # Z
    .param p6, "z9"    # Z

    .line 49492
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 49493
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$ChatFolderInfo;->id:I

    .line 49494
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ChatFolderInfo;->name:Lorg/drinkless/tdlib/TdApi$ChatFolderName;

    .line 49495
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$ChatFolderInfo;->icon:Lorg/drinkless/tdlib/TdApi$ChatFolderIcon;

    .line 49496
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$ChatFolderInfo;->colorId:I

    .line 49497
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$ChatFolderInfo;->isShareable:Z

    .line 49498
    iput-boolean p6, p0, Lorg/drinkless/tdlib/TdApi$ChatFolderInfo;->hasMyInviteLinks:Z

    .line 49499
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 49503
    const v0, 0x309c140d

    return v0
.end method
