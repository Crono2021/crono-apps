.class public Lorg/drinkless/tdlib/TdApi$InputMessageChecklist;
.super Lorg/drinkless/tdlib/TdApi$InputMessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputMessageChecklist"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x66b25d0d


# instance fields
.field public checklist:Lorg/drinkless/tdlib/TdApi$InputChecklist;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 14730
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputMessageContent;-><init>()V

    .line 14731
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$InputChecklist;)V
    .locals 0
    .param p1, "inputChecklist"    # Lorg/drinkless/tdlib/TdApi$InputChecklist;

    .line 14721
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputMessageContent;-><init>()V

    .line 14722
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputMessageChecklist;->checklist:Lorg/drinkless/tdlib/TdApi$InputChecklist;

    .line 14723
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 14727
    const v0, -0x66b25d0d

    return v0
.end method
